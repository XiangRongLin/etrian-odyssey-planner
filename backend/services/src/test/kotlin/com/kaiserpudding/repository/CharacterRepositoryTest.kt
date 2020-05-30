package com.kaiserpudding.repository

import com.kaiserpudding.UserAccessException
import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.queryOptions.CharacterQueryOptions
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CharacterRepositoryTest : AbstractRepositoryTest() {

    private val repository = CharacterRepository()

    @Test
    fun `create(), valid`() = dbTest {
        val newCharacter = NewCharacter("name", "Hero")
        val id = repository.create(newCharacter, user.id)
        val actual = repository.get(id)

        assertTrue(actual != null)
        assertEquals(newCharacter.name, actual!!.name)
        assertEquals(newCharacter.role, actual.role.name)
    }

    @Test
    fun `create(), invalid role`() = dbTest {
        assertThrows(ExposedSQLException::class.java) {
            repository.create(NewCharacter("name", "role"), user.id)
        }
    }

    @Test
    fun `create(), invalid user`() = dbTest {
        assertThrows(ExposedSQLException::class.java) {
            repository.create(NewCharacter("name", "Hero"), -1)
        }
    }

    @Test
    fun getAll() = dbTest {
        val actual = repository.getAll()

        assertEqualsCharacter(character, actual)
    }

    @Test
    fun get() = dbTest {
        val actual = repository.get(character.id)

        assertTrue(actual != null)
        assertEquals(character.id, actual!!.id)
        assertEquals(character.name, actual.name)
        assertEquals(character.role, actual.role)
    }

    @Test
    fun `getBy(), name`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(name = character.name))

        assertEqualsCharacter(character, actual)
    }

    @Test
    fun `getBy(), name partial match`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(name = character.name.substring(1)))

        assertEqualsCharacter(character, actual)
    }

    @Test
    fun `getBy(), name ignore case`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(name = character.name.toUpperCase()))

        assertEqualsCharacter(character, actual)
    }

    @Test
    fun `getBy(), name non existent`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(name = "abcdefg"))

        assertTrue(actual.isEmpty())
    }

    @Test
    fun `getBy(), role`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(role = "Hero"))

        assertEqualsCharacter(character, actual)
    }

    @Test
    fun `getBy(), role invalid`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(role = "abcdefg"))

        assertTrue(actual.isEmpty())
    }

    @Test
    fun `getBy(), role, non existent`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(role = "Medic"))

        assertTrue(actual.isEmpty())
    }

    @Test
    fun `getBy(), user`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(user = user.id))

        assertEqualsCharacter(character, actual)
    }

    @Test
    fun `getBy(), user invalid`() = dbTest {
        val actual = repository.getBy(CharacterQueryOptions(user = -1))

        assertTrue(actual.isEmpty())
    }

    @Test
    fun `getBy(), name and role and user`() = dbTest {
        val newCharacter = NewCharacter("other", "Medic")
        val id = repository.create(newCharacter, user.id)
        repository.create(NewCharacter("third", "Protector"), user.id)
        val actual = repository.getBy(CharacterQueryOptions("other", "Medic", user.id))

        assertEqualsCharacter(CharacterSummary(id, newCharacter), actual)
    }

    @Test
    fun `update(), valid`() = dbTest {
        val summary = CharacterSummary(character.id, "new name", "Medic")
        repository.update(summary, user.id)
        val actual = repository.get(character.id)

        assertEqualsCharacter(summary, actual)
    }

    @Test
    fun `update(), invalid role`() = dbTest {
        val summary = CharacterSummary(character.id, character.name, "abcdefg")
        assertThrows(ExposedSQLException::class.java) {
            repository.update(summary, user.id)
        }
    }

    @Test
    fun `update(), non existent`() = dbTest {
        val summary = CharacterSummary(-1, "name", "abcdefg")
        repository.update(summary, user.id)

        val actual = repository.getAll()
        assertEqualsCharacter(character, actual)
    }

    @Test
    fun `update(), different user`() = dbTest {
        val summary = CharacterSummary(character.id, character.name, character.role)
        assertThrows(UserAccessException::class.java) {
            repository.update(summary, -1)
        }
    }

    @Test
    fun `delete(), valid`() = dbTest {
        repository.delete(character.id, user.id)

        val actual = repository.getAll()
        assertTrue(actual.isEmpty())
    }

    @Test
    fun `delete(), different user`() = dbTest {
        assertThrows(UserAccessException::class.java) {
            repository.delete(character.id, -1)
        }
    }

    @Test
    fun `delete(), non existent`() = dbTest {
        repository.delete(-1, user.id)

        val actual = repository.getAll()
        assertEqualsCharacter(character, actual)
    }

    private fun assertEqualsCharacter(expected: CharacterDetail, actual: List<CharacterSummary>) {
        assertTrue(actual.isNotEmpty())
        assertEquals(1, actual.size)
        assertEqualsCharacter(expected, actual.first())
    }

    private fun assertEqualsCharacter(expected: CharacterSummary, actual: List<CharacterSummary>) {
        assertTrue(actual.isNotEmpty())
        assertEquals(1, actual.size)
        assertEqualsCharacter(expected, actual.first())
    }

    private fun assertEqualsCharacter(expected: CharacterSummary, actual: CharacterSummary) {
        assertEquals(expected.id, actual.id)
        assertEquals(expected.name, actual.name)
        assertEquals(expected.role, actual.role)
    }

    private fun assertEqualsCharacter(expected: CharacterSummary, actual: CharacterDetail?) {
        assertTrue(actual != null)
        assertEquals(expected.id, actual!!.id)
        assertEquals(expected.name, actual.name)
        assertEquals(expected.role, actual.role)
    }

    private fun assertEqualsCharacter(expected: CharacterDetail, actual: CharacterSummary) {
        assertEquals(expected.id, actual.id)
        assertEquals(expected.name, actual.name)
        assertEquals(expected.role, actual.role)
    }

}
