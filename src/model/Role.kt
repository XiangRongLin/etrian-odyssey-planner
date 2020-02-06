package com.kaiserpudding.model

import org.jetbrains.exposed.sql.Table

object Roles: Table("roles") {
    val name = varchar("name", 15).primaryKey()
}

data class Role(
    val name: String
)