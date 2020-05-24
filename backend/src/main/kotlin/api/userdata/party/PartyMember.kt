package com.kaiserpudding.api.userdata.party

import com.kaiserpudding.api.userdata.character.Character

data class PartyMember(
    val character: Character,
    val position: Position
)