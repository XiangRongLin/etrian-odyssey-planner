package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object SkillInfoPrerequisiteTable : Table("skill_info_prerequisites") {
    val skillInfoId = integer("skill_info_id").references(SkillInfoTable.id).index()
    val prerequisiteId = integer("prerequisite_id").references(SkillInfoTable.id)
    val prerequisiteLevel = integer("prerequisite_level")
}

data class SkillInfoPrerequisite(
    val prerequisiteId: Int,
    val prerequisiteLevel: Int
)