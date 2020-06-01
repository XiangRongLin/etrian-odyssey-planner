package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.PartyDetail
import com.kaiserpudding.model.PartySummary
import com.kaiserpudding.repository.PartyRepository
import com.kaiserpudding.repository.UserRepository
import com.kaiserpudding.service.PartyService

internal class PartyServiceImpl(
    private val partyRepository: PartyRepository,
    private val userRepository: UserRepository
) : PartyService {

    override suspend fun create(party: NewParty, jwtId: String): Int = dbQuery {
        val user = userRepository.resolveId(jwtId)
        partyRepository.create(party, user)
    }

    override suspend fun get(party: Int): PartyDetail? = dbQuery {
        partyRepository.get(party)
    }

    override suspend fun getAll(): List<PartySummary> = dbQuery {
        partyRepository.getAll()
    }

    override suspend fun update(party: PartySummary, jwtId: String): Unit = dbQuery {
        val user = userRepository.resolveId(jwtId)
        partyRepository.update(party, user)
    }

    override suspend fun delete(party: Int, jwtId: String): Boolean = dbQuery {
        val user = userRepository.resolveId(jwtId)
        partyRepository.delete(party, user)
    }

    override suspend fun updateMembers(party: Int, members: List<NewPartyMember>, jwtId: String): Unit = dbQuery {
        val user = userRepository.resolveId(jwtId)
        partyRepository.insertOrUpdateMembers(party, members, user)
    }
}