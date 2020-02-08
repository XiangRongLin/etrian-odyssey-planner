package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object PartyTable: Table("parties") {
    val id = integer("id").primaryKey().autoIncrement().uniqueIndex()
    val name = varchar("name", 20)
}

data class Party(
    val id: Int,
    val name: String
)

data class NewParty(
    val id: Int?,
    val name: String
)