package com.kaiserpudding.model

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object PartyMemberTable : Table("party_members") {
    val partyId = integer("party_id").index()
        .references(PartyTable.id, onDelete = ReferenceOption.NO_ACTION)
    val memberId = integer("member_id")
        .references(CharacterTable.id, onDelete = ReferenceOption.CASCADE)
    val position = enumerationByName("position", 15, Position::class)

    init {
        uniqueIndex(partyId, memberId)
        uniqueIndex(partyId, position)
    }
}

data class PartyMember(
    val partyId: Int,
    val memberId: Int,
    val position: Position
)

data class PartyMemberApi(
    val member: Character,
    val position: Position
)

enum class Position {
    FRONT_LEFT,
    FRONT_MIDDLE,
    FRONT_RIGHT,
    BACK_LEFT,
    BACK_MIDDLE,
    BACK_RIGHT
}