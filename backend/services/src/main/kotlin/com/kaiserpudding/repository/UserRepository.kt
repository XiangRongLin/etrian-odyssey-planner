package com.kaiserpudding.repository

import com.kaiserpudding.database.UserTable
import com.kaiserpudding.model.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class UserRepository : AbstractRepository() {
    fun create(): Int = UserTable.insert { }[UserTable.id]

    fun get(id: Int): User? = UserTable
        .select { UserTable.id eq id }
        .mapNotNull { toUser(it) }
        .singleOrNull()

    private fun toUser(row: ResultRow) = User(
        id = row[UserTable.id]
    )
}