package com.kaiserpudding.api.userdata.party

data class Party(
    val id: Int,
    val name: String
)

data class NewParty(
    val id: Int?,
    val name: String
)