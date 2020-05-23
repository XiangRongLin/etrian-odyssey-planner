package com.kaiserpudding.api.userdata.character

data class Character(
    val id: Int,
    val name: String,
    val role: String
)

data class NewCharacter(
    val id: Int?,
    val name: String,
    val role: String
)