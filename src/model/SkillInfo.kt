package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object SkillInfos: Table("skill_infos") {
    val id = integer("id"). primaryKey().uniqueIndex()
    val roleName = varchar("role_name", 15).references(Roles.name)
    val name = varchar("name", 30)
    val description = varchar("description", 400)
    val maxLevel = integer("max_level")
}

data class SkillInfo(
    val id: Int,
    val name: String,
    val description: String,
    val maxLevel: Int
)