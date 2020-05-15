package com.kaiserpudding.model

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object SkillInfoPrerequisiteTable : Table("skill_info_prerequisites") {
    val skillInfoId = integer("skill_info_id").index().references(
        SkillInfoTable.id,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.CASCADE
    )
    val prerequisiteId = integer("prerequisite_id")
        .references(
            SkillInfoTable.id,
            onUpdate = ReferenceOption.CASCADE,
            onDelete = ReferenceOption.CASCADE
        )
    val prerequisiteLevel = integer("prerequisite_level")
}

data class SkillInfoPrerequisite(
    val prerequisiteId: Int,
    val prerequisiteLevel: Int
)