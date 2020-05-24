package com.kaiserpudding.repository

import com.kaiserpudding.api.gamedata.role.Role
import com.kaiserpudding.database.RoleTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.selectAll

class RoleRepository(schema: Schema? = null) : AbstractRepository(schema) {

    suspend fun getAll(): List<Role> {
        return dbQuery {
            RoleTable.selectAll().map { toRole(it) }
        }
    }

    private fun toRole(row: ResultRow): Role {
        return Role(
            name = row[RoleTable.name]
        )
    }
}