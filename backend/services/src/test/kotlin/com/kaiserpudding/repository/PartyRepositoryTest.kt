package com.kaiserpudding.repository

import com.kaiserpudding.UserAccessException
import com.kaiserpudding.model.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class PartyRepositoryTest : AbstractRepositoryTest() {

    private val repository = PartyRepository()

    @Test
    fun create() = dbTest {
        val newParty = NewParty("name")
        val id = repository.create(newParty, user.id)

        val actual = repository.get(id)
        assertTrue(actual != null)
        assertEquals(newParty.name, actual!!.name)
        assertTrue(actual.members.isEmpty())
    }

    @Test
    fun `create(), non-existent user, invalid`() = dbTest {
        assertThrows(ExposedSQLException::class.java) {
            repository.create(NewParty("name"), -1)
        }
    }

    @Test
    fun getAll() = dbTest {
        val actual = repository.getAll()
        assertEquals(1, actual.size)
        assertEquals(party.id, actual.first().id)
        assertEquals(party.name, actual.first().name)
    }

    @Test
    fun get() = dbTest {
        val actual = repository.get(party.id)
        assertTrue(actual != null)
        assertEquals(party.name, actual!!.name)
    }

    @Test
    fun `get(), non-existent`() = dbTest {
        val actual = repository.get(-1)
        assertTrue(actual == null)
    }

    @Test
    fun update() = dbTest {
        val name = "new name"
        repository.update(PartySummary(party.id, name), user.id)

        val actual = repository.get(party.id)
        assertTrue(actual != null)
        assertEquals(name, actual!!.name)
    }

    @Test
    fun `update(), other user, invalid`() = dbTest {
        assertThrows(UserAccessException::class.java) {
            repository.update(PartySummary(party.id, "new name"), -1)
        }
    }

    @Test
    fun delete() = dbTest {
        val succeed = repository.delete(party.id, user.id)

        assertTrue(succeed)
        assertTrue(repository.get(party.id) == null)
    }

    @Test
    fun `delete(), other user, invalid`() = dbTest {
        assertThrows(UserAccessException::class.java) {
            repository.delete(party.id, -1)
        }
    }

    @Test
    fun `updateMember(), change position of member in party`() = dbTest {
        val member = NewPartyMember(character.id, Position.BACK_LEFT)
        repository.insertOrUpdateMembers(party.id, listOf(member), user.id)

        val actual = repository.get(party.id)
        assertEquals(Position.BACK_LEFT, actual!!.members.first().position)
    }

    @Test
    fun `updateMember(), add member to party, doesn't modify existing members`() = dbTest {
        val character = NewCharacter("name", "Medic")
        val characterId = CharacterRepository().create(character, user.id)
        val member = NewPartyMember(characterId, Position.BACK_LEFT)
        repository.insertOrUpdateMembers(party.id, listOf(member), user.id)

        val actual = repository.get(party.id)
        assertEquals(2, actual!!.members.size)
        assertEqualsMember(party.members[0], actual.members[0])
        assertEqualsMember(member, actual.members[1])
    }


    @Test
    fun `updateMember(), remove member from party`() = dbTest {
        val member = NewPartyMember(character.id, Position.NOT_IN_PARTY)
        repository.insertOrUpdateMembers(party.id, listOf(member), user.id)

        val actual = repository.get(party.id)
        assertTrue(actual!!.members.isEmpty())
    }

    @Test
    fun `updateMember(), add and change members`() = dbTest {
        val newCharacter = NewCharacter("name", "Medic")
        val characterId = CharacterRepository().create(newCharacter, user.id)
        val newMember = NewPartyMember(characterId, Position.BACK_RIGHT)

        val member = NewPartyMember(character.id, Position.BACK_LEFT)
        repository.insertOrUpdateMembers(party.id, listOf(member, newMember), user.id)

        val actual = repository.get(party.id)
        assertEquals(2, actual!!.members.size)
        assertEqualsMember(member, actual.members[0])
        assertEqualsMember(newMember, actual.members[1])
    }

    @Test
    fun `updateMember(), add character from other user to own party`() = dbTest {
        val userId = UserRepository().create()
        val partyId = PartyRepository().create(NewParty("name"), userId)
        val member = NewPartyMember(character.id, Position.BACK_LEFT)
        repository.insertOrUpdateMembers(partyId, listOf(member), userId)

        val actual = repository.get(partyId)
        assertEquals(1, actual!!.members.size)
        assertEqualsMember(member, actual.members.first())
    }

    @Test
    fun `updateMember(), change member of other user, invalid`() = dbTest {
        assertThrows(UserAccessException::class.java) {
            repository.insertOrUpdateMembers(party.id, listOf(NewPartyMember(character.id, Position.BACK_LEFT)), -1)
        }
    }

    @Test
    fun `updateMember(), duplicate position, invalid`() = dbTest {
        val character = NewCharacter("name", "Medic")
        val characterId = CharacterRepository().create(character, user.id)
        val member = NewPartyMember(characterId, party.members.first().position)
        assertThrows(ExposedSQLException::class.java) {
            repository.insertOrUpdateMembers(party.id, listOf(member), user.id)
        }
    }

    @Test
    fun `updateMember(), same member in multiple parties`() = dbTest {
        val partyId = PartyRepository().create(NewParty("name"), user.id)
        val member = NewPartyMember(character.id, Position.BACK_LEFT)
        repository.insertOrUpdateMembers(partyId, listOf(member), user.id)

        val actual = repository.get(partyId)
        assertEquals(1, actual!!.members.size)
        assertEqualsMember(member, actual.members.first())
    }

    private fun assertEqualsMember(expected: NewPartyMember, actual: PartyMember) {
        assertEquals(expected.characterId, actual.characterSummary.id)
        assertEquals(expected.position, actual.position)
    }

    private fun assertEqualsMember(expected: PartyMember, actual: PartyMember) {
        assertEquals(expected.characterSummary.id, actual.characterSummary.id)
        assertEquals(expected.position, actual.position)
    }
}