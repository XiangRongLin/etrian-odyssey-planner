package com.kaiserpudding.model

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object CharacterTable : Table("characters") {
    val id = integer("id").primaryKey().autoIncrement().uniqueIndex()
    val name = varchar("name", 30)
    val role = varchar("role", 15).references(
        RoleTable.name,
        onUpdate = ReferenceOption.CASCADE,
        onDelete = ReferenceOption.RESTRICT
    )
}

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