package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object CharacterTable: Table("characters") {
    val id = integer("id").primaryKey().autoIncrement().uniqueIndex()
    val name = varchar("name", 30)
}

data class Character(
    val id: Int,
    val name: String
)

data class NewCharacter(
    val id : Int?,
    val name: String
)