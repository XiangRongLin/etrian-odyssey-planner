package com.kaiserpudding.repository

import com.kaiserpudding.database.PartyMemberTable
import com.kaiserpudding.database.PartyTable
import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.Party
import com.kaiserpudding.model.PartyMember
import com.kaiserpudding.model.Position
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class PartyRepository : AbstractRepository() {

    fun create(party: NewParty, user: Int): Int {
        return PartyTable.insert {
            it[name] = party.name
            it[userId] = user
        }[PartyTable.id]
    }

    fun getAll(): List<Party> {
        return PartyTable.selectAll().map { toParty(it) }
    }

    fun get(id: Int): Party? {
        return PartyTable.select { PartyTable.id.eq(id) }
            .limit(1)
            .map { toParty(it) }
            .singleOrNull()
    }

    private fun toParty(row: ResultRow) = Party(
        id = row[PartyTable.id],
        name = row[PartyTable.name],
        members = getPartyMembers(row[PartyTable.id])
    )

    fun update(party: Party, user: Int) {
        PartyTable
            .verifyUser(party.id, user)
            ?.update({ PartyTable.id.eq(party.id) }) {
                it[name] = party.name
            }
    }

    fun delete(id: Int, user: Int): Boolean {
        val count = PartyTable
            .verifyUser(id, user)
            ?.deleteWhere { PartyTable.id.eq(id) }
        return count == null || count > 0
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
            ?.update({
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
        val count = PartyMemberTable
            .verifyUser(party, user)
            ?.deleteWhere {
                (PartyMemberTable.partyId eq party) and (PartyMemberTable.memberId eq character)
            }
        return count == null || count > 0
    }
}