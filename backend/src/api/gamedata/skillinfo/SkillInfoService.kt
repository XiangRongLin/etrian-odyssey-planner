package com.kaiserpudding.api.gamedata.skillinfo

import com.kaiserpudding.api.gamedata.role.Role
import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.database.SkillInfoPrerequisiteTable
import com.kaiserpudding.database.SkillInfoTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class SkillInfoService {

    suspend fun getAll(): List<SkillInfo> {
        return dbQuery {
            SkillInfoTable.selectAll().map { toSkillInfo(it) }
        }
    }

    suspend fun getByRole(role: Role): List<SkillInfo> {
        return dbQuery {
            SkillInfoTable
                .select { SkillInfoTable.roleName eq role.name }
                .mapNotNull { toSkillInfo(it) }
        }
    }

    suspend fun get(id: Int): SkillInfo? {
        return dbQuery {
            SkillInfoTable
                .select { SkillInfoTable.id eq id }
                .limit(1)
                .mapNotNull { toSkillInfo(it) }
                .singleOrNull()
        }
    }

    private suspend fun toSkillInfo(row: ResultRow): SkillInfo {
        return SkillInfo(
            id = row[SkillInfoTable.id],
            role = Role(row[SkillInfoTable.roleName]),
            name = row[SkillInfoTable.name],
            description = row[SkillInfoTable.description],
            maxLevel = row[SkillInfoTable.maxLevel],
            prerequisites = getPrerequisite(row[SkillInfoTable.id])
        )
    }

    private suspend fun getPrerequisite(id: Int): List<SkillInfoPrerequisite>? {
        return dbQuery {
            SkillInfoPrerequisiteTable
                .select { SkillInfoPrerequisiteTable.skillInfoId eq id }
                .map { toPrerequisite(it) }
        }
    }

    private fun toPrerequisite(row: ResultRow): SkillInfoPrerequisite {
        return SkillInfoPrerequisite(
            id = row[SkillInfoPrerequisiteTable.prerequisiteId],
            level = row[SkillInfoPrerequisiteTable.prerequisiteLevel]
        )
    }


}