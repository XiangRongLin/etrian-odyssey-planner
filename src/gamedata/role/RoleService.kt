package com.kaiserpudding.gamedata.role

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Role
import com.kaiserpudding.model.Roles
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.selectAll

class RoleService {

    suspend fun getAll(): List<Role> = dbQuery {
        Roles.selectAll().map { toClass(it) }
    }

    private fun toClass(row: ResultRow): Role = Role(
        name = row[Roles.name]
    )

    suspend fun insertAll(roleNames: Iterable<String>) {
        Roles.batchInsert(roleNames) { name ->
            this[Roles.name] = name
        }
    }
}