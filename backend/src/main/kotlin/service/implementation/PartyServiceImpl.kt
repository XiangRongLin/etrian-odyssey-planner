package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.Party
import com.kaiserpudding.repository.PartyRepository
import com.kaiserpudding.service.PartyService

internal class PartyServiceImpl(private val partyRepository: PartyRepository) : PartyService {

    override suspend fun create(party: NewParty): Int = dbQuery {
        partyRepository.create(party)
    }

    override suspend fun get(party: Int): Party? = dbQuery {
        partyRepository.get(party)
    }

    override suspend fun getAll(): List<Party> = dbQuery {
        partyRepository.getAll()
    }

    override suspend fun update(party: Party): Unit = dbQuery {
        partyRepository.update(party)
    }

    override suspend fun delete(party: Int): Boolean = dbQuery {
        partyRepository.delete(party)
    }

    override suspend fun updateMembers(party: Int, members: List<NewPartyMember>): Unit = dbQuery {
        partyRepository.updateMembers(party, members)
    }
}