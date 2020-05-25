package com.kaiserpudding.model

data class PartyMember(
    val characterSummary: CharacterSummary,
    val position: Position
)

data class NewPartyMember(
    val characterId: Int,
    val position: Position
)