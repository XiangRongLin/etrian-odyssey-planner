package com.kaiserpudding.repository

import com.kaiserpudding.api.gamedata.role.Role
import com.kaiserpudding.api.gamedata.skillinfo.SkillInfo
import com.kaiserpudding.api.gamedata.skillinfo.SkillInfoPrerequisite
import com.kaiserpudding.database.SkillInfoPrerequisiteTable
import com.kaiserpudding.database.SkillInfoTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class SkillInfoRepository(schema: Schema? = null) : AbstractRepository(schema) {

    suspend fun getAll(): List<SkillInfo> = dbQuery {
        SkillInfoTable.selectAll().map { toSkillInfo(it) }
    }

    suspend fun getByRole(role: Role): List<SkillInfo> = dbQuery {
        SkillInfoTable
            .select { SkillInfoTable.roleName eq role.name }
            .mapNotNull { toSkillInfo(it) }
    }

    suspend fun get(id: Int): SkillInfo? = dbQuery {
        SkillInfoTable
            .select { SkillInfoTable.id eq id }
            .limit(1)
            .mapNotNull { toSkillInfo(it) }
            .singleOrNull()
    }

    suspend fun get(ids: Iterable<Int>): List<SkillInfo> = dbQuery {
        SkillInfoTable
            .select { SkillInfoTable.id inList ids }
            .mapNotNull { toSkillInfo(it) }
            .toList()
    }

    private suspend fun toSkillInfo(row: ResultRow): SkillInfo =
        SkillInfo(
            id = row[SkillInfoTable.id],
            role = Role(row[SkillInfoTable.roleName]),
            name = row[SkillInfoTable.name],
            description = row[SkillInfoTable.description],
            maxLevel = row[SkillInfoTable.maxLevel],
            prerequisites = getPrerequisite(row[SkillInfoTable.id])
        )

    private suspend fun getPrerequisite(id: Int): List<SkillInfoPrerequisite>? = dbQuery {
        SkillInfoPrerequisiteTable
            .select { SkillInfoPrerequisiteTable.skillInfoId eq id }
            .map { toPrerequisite(it) }
    }

    private fun toPrerequisite(row: ResultRow): SkillInfoPrerequisite =
        SkillInfoPrerequisite(
            id = row[SkillInfoPrerequisiteTable.prerequisiteId],
            level = row[SkillInfoPrerequisiteTable.prerequisiteLevel]
        )


}