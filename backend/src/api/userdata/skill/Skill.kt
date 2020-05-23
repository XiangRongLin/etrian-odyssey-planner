package com.kaiserpudding.api.userdata.skill

data class Skill(
    val id: Int,
    val skillInfoId: Int,
    val level: Int
) {
    constructor(id: Int, skill: NewSkill) : this(id, skill.skillInfoId, skill.level)
}

data class NewSkill(
    val id: Int? = null,
    val skillInfoId: Int,
    val level: Int
)