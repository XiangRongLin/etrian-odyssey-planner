package com.kaiserpudding.service.demo

import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.PartyDetail
import com.kaiserpudding.model.PartySummary
import com.kaiserpudding.service.PartyService

internal class PartyServiceDemo : PartyService {
    override suspend fun create(party: NewParty, jwtId: String): Int {
        TODO("Not yet implemented")
    }

    override suspend fun get(party: Int): PartyDetail? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<PartySummary> {
        TODO("Not yet implemented")
    }

    override suspend fun update(party: PartySummary, jwtId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(party: Int, jwtId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateMembers(party: Int, members: List<NewPartyMember>, jwtId: String) {
        TODO("Not yet implemented")
    }
}