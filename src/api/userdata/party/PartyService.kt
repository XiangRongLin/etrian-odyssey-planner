package com.kaiserpudding.api.userdata.party

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.extension.upsert
import com.kaiserpudding.model.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.postgresql.util.PSQLException
import java.lang.Exception

class PartyService {

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

    private fun toParty(row: ResultRow): Party = Party(
        id = row[PartyTable.id],
        name = row[PartyTable.name]
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

    suspend fun getPartyMembers(partyId: Int): List<PartyMember> = dbQuery {
        PartyMemberTable.select { PartyMemberTable.partyId.eq(partyId) }
            .map { toMember(it) }
    }

    private fun toMember(row: ResultRow): PartyMember = PartyMember(
        partyId = row[PartyMemberTable.partyId],
        memberId = row[PartyMemberTable.memberId],
        position = row[PartyMemberTable.position]
    )

    suspend fun upsertMember(member: PartyMember) = dbQuery {
        PartyMemberTable.upsert(PartyMemberTable.partyId, PartyMemberTable.memberId) {
            it[partyId] = member.partyId
            it[memberId] = member.memberId
            it[position] = member.position
        }
    }

    suspend fun addMember(member: PartyMember): InsertStatement<Number> {
        return dbQuery {
            PartyMemberTable.insert {
                it[partyId] = member.partyId
                it[memberId] = member.memberId
                it[position] = member.position
            }
        }
    }

    suspend fun updateMemberPosition(member: PartyMember) = dbQuery {
        PartyMemberTable.update({
            PartyMemberTable.partyId.eq(member.partyId)
                .and(
                    PartyMemberTable.memberId.eq(member.memberId)
                )
        }) {
            it[position] = member.position
        }
    }

    suspend fun removeMember(partyId: Int, memberId: Int): Boolean = dbQuery {
        PartyMemberTable.deleteWhere {
            PartyMemberTable.partyId.eq(partyId)
                .and(
                    PartyMemberTable.memberId.eq(memberId)
                )
        } > 0
    }
}