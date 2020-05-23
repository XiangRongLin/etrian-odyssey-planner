package com.kaiserpudding.api.gamedata.role

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.database.RoleTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class RoleService {

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