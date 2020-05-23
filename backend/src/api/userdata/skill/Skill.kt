package com.kaiserpudding.api.userdata.skill

data class Skill(
    val id: Int,
    val skillInfoId: Int,
    val level: Int,
    val characterId: Int
)

data class NewSkill(
    val id: Int?,
    val skillInfoId: Int,
    val level: Int,
    val characterId: Int
)