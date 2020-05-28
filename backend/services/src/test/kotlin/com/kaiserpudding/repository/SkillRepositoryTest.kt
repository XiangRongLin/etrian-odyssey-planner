package com.kaiserpudding.repository

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
    fun `insertOrUpdate(), create single valid skill`() = dbTest {
        repository.insertOrUpdate(character.id, listOf(Skill(3, 4)), user.id)
        val actual = repository.getByCharacter(character.id)

        assertEquals(2, actual.size)
        assertEquals(3, actual[1].skillInfoId)
        assertEquals(4, actual[1].level)
    }

    @Test
    fun `insertOrUpdate(), update level`() = dbTest {
        val skill = character.skills.first()
        val updatedSkill = Skill(skill.skillInfoId, skill.level + 1)
        repository.insertOrUpdate(character.id, listOf(updatedSkill), user.id)
        val actual = repository.getByCharacter(character.id)

        assertEquals(1, actual.size)
        assertEquals(skill.skillInfoId, actual.first().skillInfoId)
        assertEquals(skill.level + 1, actual.first().level)
    }

}