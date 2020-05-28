package com.kaiserpudding.service

import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.Party

interface PartyService {
    suspend fun create(party: NewParty, user: Int): Int

    suspend fun get(party: Int): Party?

    suspend fun getAll(): List<Party>

    suspend fun update(party: Party, user: Int)

    suspend fun delete(party: Int, user: Int): Boolean

    suspend fun updateMembers(party: Int, members: List<NewPartyMember>, user: Int)
}