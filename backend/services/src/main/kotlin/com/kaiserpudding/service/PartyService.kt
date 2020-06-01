package com.kaiserpudding.service

import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.PartyDetail
import com.kaiserpudding.model.PartySummary

interface PartyService {
    suspend fun create(party: NewParty, jwtId: String): Int

    suspend fun get(party: Int): PartyDetail?

    suspend fun getAll(): List<PartySummary>

    suspend fun update(party: PartySummary, jwtId: String)

    suspend fun delete(party: Int, jwtId: String): Boolean

    suspend fun updateMembers(party: Int, members: List<NewPartyMember>, jwtId: String)
}