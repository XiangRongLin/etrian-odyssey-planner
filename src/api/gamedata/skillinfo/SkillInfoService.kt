package com.kaiserpudding.api.gamedata.skillinfo

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class SkillInfoService {

    suspend fun getAll(): List<SkillInfo> = dbQuery {
        SkillInfoTable.selectAll().map { toSkillInfo(it) }
    }

    suspend fun get(id: Int): SkillInfo? = dbQuery {
        SkillInfoTable
            .select { SkillInfoTable.id eq id }
            .limit(1)
            .mapNotNull { toSkillInfo(it) }
            .singleOrNull()
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

    private suspend fun getPrerequisite(id: Int): List<SkillInfoPrerequisite>? = dbQuery {
        SkillInfoPrerequisiteTable
            .select { SkillInfoPrerequisiteTable.skillInfoId eq id }
            .map { toPrerequisite(it) }
    }

    private fun toPrerequisite(row: ResultRow): SkillInfoPrerequisite =
        SkillInfoPrerequisite(
            prerequisiteId = row[SkillInfoPrerequisiteTable.prerequisiteId],
            prerequisiteLevel = row[SkillInfoPrerequisiteTable.prerequisiteLevel]
        )
}