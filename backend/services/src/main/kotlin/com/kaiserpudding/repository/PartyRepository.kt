package com.kaiserpudding.repository

import com.kaiserpudding.database.PartyMemberTable
import com.kaiserpudding.database.PartyTable
import com.kaiserpudding.model.*
import org.jetbrains.exposed.sql.*

class PartyRepository : AbstractRepository() {

    fun create(party: NewParty, user: Int): Int {
        return PartyTable.insert {
            it[name] = party.name
            it[userId] = user
        }[PartyTable.id]
    }

    fun getAll(): List<PartySummary> {
        return PartyTable.selectAll().map { toPartySummary(it) }
    }

    private fun toPartySummary(row: ResultRow) = PartySummary(
        id = row[PartyTable.id],
        name = row[PartyTable.name]
    )

    fun get(id: Int): PartyDetail? {
        return PartyTable.select { PartyTable.id.eq(id) }
            .limit(1)
            .map { toPartyDetail(it) }
            .singleOrNull()
    }

    private fun toPartyDetail(row: ResultRow) = PartyDetail(
        id = row[PartyTable.id],
        name = row[PartyTable.name],
        members = getPartyMembers(row[PartyTable.id])
    )

    fun update(party: PartySummary, user: Int) {
        PartyTable
            .verifyUser(party.id, user)
            .update({ PartyTable.id.eq(party.id) }) {
                it[name] = party.name
            }
    }

    fun delete(id: Int, user: Int): Boolean {
        return PartyTable
            .verifyUser(id, user)
            .deleteWhere { PartyTable.id.eq(id) } > 0
    }

    private fun getPartyMembers(partyId: Int): List<PartyMember> {
        return PartyMemberTable.select { PartyMemberTable.partyId.eq(partyId) }
            .map { toMember(it) }
    }

    private fun toMember(row: ResultRow): PartyMember =
        PartyMember(
            characterSummary = CharacterRepository().getNonNullable(row[PartyMemberTable.memberId]),
            position = row[PartyMemberTable.position]
        )

    internal fun createMember(party: Int, member: NewPartyMember, user: Int) {
        PartyMemberTable.insert {
            it[partyId] = party
            it[memberId] = member.characterId
            it[position] = member.position
        }
    }

    private fun updateMember(party: Int, member: NewPartyMember, user: Int) {
        PartyMemberTable
            .verifyUser(party, user)
            .update({
                ((PartyMemberTable.partyId eq party) and (PartyMemberTable.memberId eq member.characterId))
            }) {
                it[position] = member.position
            }
    }

    fun updateMembers(party: Int, members: List<NewPartyMember>, user: Int) {
        members.forEach { member ->
            if (member.position == Position.NOT_IN_PARTY) {
                deleteMember(party, member.characterId, user)
            } else {
                updateMember(party, member, user)
            }
        }
    }

    private fun deleteMember(party: Int, character: Int, user: Int): Boolean {
        return PartyMemberTable
            .verifyUser(party, user)
            .deleteWhere {
                (PartyMemberTable.partyId eq party) and (PartyMemberTable.memberId eq character)
            } > 0
    }
}