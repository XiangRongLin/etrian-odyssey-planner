package com.kaiserpudding.api.model

import com.kaiserpudding.api.userdata.character.Character
import com.kaiserpudding.api.userdata.party.Position

data class PartyMember(
    val partyId: Int,
    val memberId: Int,
    val position: Position
)

data class PartyMemberApi(
    val member: Character,
    val position: Position
)
