package com.kaiserpudding.model

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object SkillTable: Table("skill") {
    val id = integer("id").primaryKey().uniqueIndex().autoIncrement()
    val skillInfoId = integer("skill_info_id").references(SkillInfoTable.id, onDelete = ReferenceOption.CASCADE)
    val level = integer("level")
    val characterId = integer("character_id").references(CharacterTable.id, onDelete = ReferenceOption.CASCADE)
}

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