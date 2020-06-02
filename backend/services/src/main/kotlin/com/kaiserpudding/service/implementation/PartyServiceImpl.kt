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

    override suspend fun create(party: NewParty, jwtSubject: String): Int = dbQuery {
        val user = userRepository.resolveSubject(jwtSubject)
        partyRepository.create(party, user)
    }

    override suspend fun get(party: Int): PartyDetail? = dbQuery {
        partyRepository.get(party)
    }

    override suspend fun getAll(): List<PartySummary> = dbQuery {
        partyRepository.getAll()
    }

    override suspend fun update(party: PartySummary, jwtSubject: String): Unit = dbQuery {
        val user = userRepository.resolveSubject(jwtSubject)
        partyRepository.update(party, user)
    }

    override suspend fun delete(party: Int, jwtSubject: String): Boolean = dbQuery {
        val user = userRepository.resolveSubject(jwtSubject)
        partyRepository.delete(party, user)
    }

    override suspend fun updateMembers(party: Int, members: List<NewPartyMember>, jwtSubject: String): Unit = dbQuery {
        val user = userRepository.resolveSubject(jwtSubject)
        partyRepository.insertOrUpdateMembers(party, members, user)
    }
}