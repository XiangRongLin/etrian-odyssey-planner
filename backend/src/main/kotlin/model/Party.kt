package com.kaiserpudding.model

data class Party(
    val id: Int,
    val name: String,
    val members: List<PartyMember>
) {
    constructor(id: Int, party: NewParty) : this(id, party.name, emptyList())
}

data class NewParty(
    val name: String
)