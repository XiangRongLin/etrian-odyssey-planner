package com.kaiserpudding.service.demo

import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.Party
import com.kaiserpudding.service.PartyService

internal class PartyServiceDemo : PartyService {
    override suspend fun create(party: NewParty): Int {
        TODO("Not yet implemented")
    }

    override suspend fun get(party: Int): Party? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Party> {
        TODO("Not yet implemented")
    }

    override suspend fun update(party: Party) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(party: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateMembers(party: Int, members: List<NewPartyMember>) {
        TODO("Not yet implemented")
    }
}