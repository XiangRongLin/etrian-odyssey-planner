package com.kaiserpudding.api.gamedata.skillinfo

import com.kaiserpudding.api.gamedata.role.Role

data class SkillInfo(
    val id: Int,
    val role: Role,
    val name: String,
    val description: String,
    val maxLevel: Int,
    val prerequisites: List<SkillInfoPrerequisite>? = null
)