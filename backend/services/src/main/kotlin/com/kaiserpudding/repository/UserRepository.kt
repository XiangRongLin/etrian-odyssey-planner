package com.kaiserpudding.repository

import com.kaiserpudding.database.UserTable
import com.kaiserpudding.model.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class UserRepository : AbstractRepository() {
    fun create(jwt: String): Int = UserTable.insert {
        it[jwtSubject] = jwt
    }[UserTable.id]

    fun get(id: Int): User? = UserTable
        .select { UserTable.id eq id }
        .mapNotNull { toUser(it) }
        .singleOrNull()


    fun resolveSubject(jwtSubject: String): Int = UserTable
        .select { UserTable.jwtSubject eq jwtSubject }
        .single()[UserTable.id]

    private fun toUser(row: ResultRow) = User(
        id = row[UserTable.id]
    )
}