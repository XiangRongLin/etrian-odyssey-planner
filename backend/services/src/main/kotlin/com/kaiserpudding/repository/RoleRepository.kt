package com.kaiserpudding.repository

import com.kaiserpudding.database.RoleTable
import com.kaiserpudding.model.Role
import com.kaiserpudding.repository.AbstractRepository
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class RoleRepository : AbstractRepository() {

    fun getAll(): List<Role> =
        RoleTable.selectAll().map { toRole(it) }

    private fun toRole(row: ResultRow) = Role(
        name = row[RoleTable.name]
    )
}