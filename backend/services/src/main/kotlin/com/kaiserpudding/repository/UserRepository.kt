package com.kaiserpudding.repository

import com.kaiserpudding.database.UserTable
import com.kaiserpudding.repository.AbstractRepository
import org.jetbrains.exposed.sql.insert

class UserRepository : AbstractRepository() {
    fun create(): Int = UserTable.insert { }[UserTable.id]
}