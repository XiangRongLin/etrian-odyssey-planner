package com.kaiserpudding.repository

import com.kaiserpudding.api.userdata.party.NewParty
import com.kaiserpudding.api.userdata.party.Party
import com.kaiserpudding.api.userdata.party.PartyMember
import com.kaiserpudding.database.PartyMemberTable
import com.kaiserpudding.database.PartyTable
import com.kaiserpudding.extension.upsert
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class PartyRepository(schema: Schema? = null) : AbstractRepository(schema) {

    suspend fun create(party: NewParty): Int = dbQuery {
        PartyTable.insert {
            it[name] = party.name
        }[PartyTable.id]
    }

    suspend fun getAll(): List<Party> = dbQuery {
        PartyTable.selectAll().map { toParty(it) }
    }

    suspend fun get(id: Int): Party? = dbQuery {
        PartyTable.select { PartyTable.id.eq(id) }
            .limit(1)
            .map { toParty(it) }
            .singleOrNull()
    }

    private suspend fun toParty(row: ResultRow): Party =
        Party(
            id = row[PartyTable.id],
            name = row[PartyTable.name],
            members = getPartyMembers(row[PartyTable.id])
        )

    suspend fun update(party: Party): Party? = dbQuery {
        PartyTable.update({ PartyTable.id.eq(party.id) }) {
            it[name] = party.name
        }
        get(party.id)
    }

    suspend fun delete(id: Int): Boolean = dbQuery {
        PartyTable.deleteWhere { PartyTable.id.eq(id) } > 0
    }

    private suspend fun getPartyMembers(partyId: Int): List<PartyMember> = dbQuery {
        PartyMemberTable.select { PartyMemberTable.partyId.eq(partyId) }
            .map { toMember(it) }
    }

    private suspend fun toMember(row: ResultRow): PartyMember =
        PartyMember(
            character = CharacterRepository().getNonNullable(row[PartyMemberTable.memberId]),
            position = row[PartyMemberTable.position]
        )

    suspend fun updateMembers(party: Int, members: List<PartyMember>) = dbQuery {
        members.forEach { member ->
            PartyMemberTable.upsert(PartyMemberTable.partyId, PartyMemberTable.memberId) {
                it[partyId] = party
                it[memberId] = member.character.id
                it[position] = member.position
            }
        }
    }

    suspend fun removeMember(partyId: Int, memberId: Int): Boolean = dbQuery {
        PartyMemberTable.deleteWhere {
            PartyMemberTable.partyId.eq(partyId).and(PartyMemberTable.memberId.eq(memberId))
        } > 0
    }

    suspend fun deleteAll() = dbQuery {
        PartyTable.deleteAll()
    }
}