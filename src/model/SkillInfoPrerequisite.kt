package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object SkillInfoPrerequisites : Table("skill_info_prerequisites") {
    val skillInfoId = integer("skill_info_id").references(SkillInfos.id).index()
    val prerequisiteId = integer("prerequisite_id").references(SkillInfos.id)
    val prerequisiteLevel = integer("prerequisite_level")
}

data class SkillInfoPrerequisite(
    val skillInfoId: Int,
    val prerequisiteId: Int
)