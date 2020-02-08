package com.kaiserpudding.api.gamedata.role

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Role
import com.kaiserpudding.model.RoleTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.selectAll

class RoleService {

    suspend fun getAll(): List<Role> = dbQuery {
        RoleTable.selectAll().map { toClass(it) }
    }

    private fun toClass(row: ResultRow): Role = Role(
        name = row[RoleTable.name]
    )

    suspend fun insertAll(roleNames: Iterable<String>) {
        RoleTable.batchInsert(roleNames) { name ->
            this[RoleTable.name] = name
        }
    }
}