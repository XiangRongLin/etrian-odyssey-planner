package com.kaiserpudding.repository

import com.kaiserpudding.SkillRestrictionException
import com.kaiserpudding.UserAccessException
import com.kaiserpudding.model.Skill
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SkillRepositoryTest : AbstractRepositoryTest() {

    private val repository = SkillRepository()

    @Test
    fun `getByCharacter(), invalid character`() = dbTest {
        val actual = repository.getByCharacter(-1)
        assertTrue(actual.isEmpty())
    }

    @Test
    fun `getByCharacter(), single skill`() = dbTest {
        val actual = repository.getByCharacter(character.id)

        assertFalse(actual.isEmpty())
        assertEquals(1, actual.size)
        assertEquals(character.skills.first(), actual.first())
    }

    @Test
    fun `insertOrUpdate(), create single skill`() = dbTest {
        repository.insertOrUpdate(character.id, listOf(Skill(3, 4)), user.id)
        val actual = repository.getByCharacter(character.id)

        assertEquals(2, actual.size)
        assertEquals(3, actual[1].skillInfoId)
        assertEquals(4, actual[1].level)
    }

    @Test
    fun `insertOrUpdate(), create single skill, but different user`() = dbTest {
        assertThrows(UserAccessException::class.java) {
            repository.insertOrUpdate(character.id, listOf(Skill(3, 4)), -1)
        }
    }

    @Test
    fun `insertOrUpdate(), valid update level`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, skill.level + 1)
        repository.insertOrUpdate(character.id, listOf(updatedSkill), user.id)
        val actual = repository.getByCharacter(character.id)

        assertEquals(1, actual.size)
        assertEquals(skill.skillInfoId, actual.first().skillInfoId)
        assertEquals(skill.level + 1, actual.first().level)
    }

    @Test
    fun `insertOrUpdate(), invalid update level because of different user`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, skill.level + 1)

        assertThrows(UserAccessException::class.java) {
            repository.insertOrUpdate(character.id, listOf(updatedSkill), -1)
        }
    }

    @Test
    fun `insertOrUpdate(), insert and update at once`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, skill.level + 1)
        val newSkill = Skill(3, 4)
        repository.insertOrUpdate(character.id, listOf(updatedSkill, newSkill), user.id)

        val actual = repository.getByCharacter(character.id)
        assertEquals(2, actual.size)
        assertEquals(updatedSkill, actual[0])
        assertEquals(newSkill, actual[1])
    }

    @Test
    fun `insertOrUpdate(), delete if level = 0`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, 0)

        repository.insertOrUpdate(character.id, listOf(updatedSkill), user.id)

        val actual = repository.getByCharacter(character.id)
        assertTrue(actual.isEmpty())
    }

    @Test
    fun `insertOrUpdate(), insert level too high`() = dbTest {
        val newSkill = Skill(3, 100)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(newSkill), user.id)
        }
    }

    @Test
    fun `insertOrUpdate(), insert negative level`() = dbTest {
        val newSkill = Skill(3, -1)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(newSkill), user.id)
        }
    }

    @Test
    fun `insertOrUpdate(), update level too high`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, 100)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(updatedSkill), user.id)
        }
    }

    @Test
    fun `insertOrUpdate(), update negative high`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, -1)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(updatedSkill), user.id)
        }
    }

    @Test
    fun `insertOrUpdate(), insert missing prerequisite`() = dbTest {
        val newSkill = Skill(5, 1)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(newSkill), user.id)
        }
    }

    @Test
    fun `insertOrUpdate(), deleting prerequisite of skill`() = dbTest {
        val newSkill = Skill(3, 1)
        repository.insertOrUpdate(character.id, listOf(newSkill), user.id)
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, 0)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(updatedSkill), user.id)
        }
    }

    @Test
    fun `insertOrUpdate(), insert skills of other role`() = dbTest {
        val newSkill = Skill(28, 1)

        assertThrows(SkillRestrictionException::class.java) {
            repository.insertOrUpdate(character.id, listOf(newSkill), user.id)
        }
    }

}