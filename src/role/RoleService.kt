package com.kaiserpudding.role

import com.kaiserpudding.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Role
import com.kaiserpudding.model.Roles
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class RoleService {

    suspend fun getAll(): List<Role> = dbQuery {
        Roles.selectAll().map { toClass(it) }
    }

    private fun toClass(row: ResultRow): Role = Role(
        id = row[Roles.id],
        name = row[Roles.name]
    )
}