package com.kaiserpudding.api.userdata.character

data class Character(
    val id: Int,
    val name: String,
    val role: String
) {
    constructor(id: Int, character: NewCharacter) : this(id, character.name, character.role)
}

data class NewCharacter(
    val name: String,
    val role: String
)