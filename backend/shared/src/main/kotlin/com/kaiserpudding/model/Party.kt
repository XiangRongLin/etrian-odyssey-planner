package com.kaiserpudding.model

data class PartyDetail(
    val id: Int,
    val name: String,
    val members: List<PartyMember>
)

data class PartySummary(
    val id: Int,
    val name: String
) {
    constructor(id: Int, party: NewParty) : this(id, party.name)
}

data class NewParty(
    val name: String
)