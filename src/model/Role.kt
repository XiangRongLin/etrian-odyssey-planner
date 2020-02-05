package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object Roles: Table() {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 15)
}

data class Role(
    val id: Int,
    val name: String
)