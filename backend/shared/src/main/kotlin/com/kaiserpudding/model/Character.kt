package com.kaiserpudding.model

data class CharacterSummary(
    val id: Int,
    val name: String,
    val role: Role
) {
    constructor(id: Int, character: NewCharacter) : this(id, character.name, Role(character.role))
}

data class CharacterDetail(
    val id: Int,
    val name: String,
    val role: Role,
    val skills: List<Skill>
)

data class NewCharacter(
    val name: String,
    val role: String
)