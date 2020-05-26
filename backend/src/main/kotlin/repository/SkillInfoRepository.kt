package com.kaiserpudding.repository

import com.kaiserpudding.database.SkillInfoPrerequisiteTable
import com.kaiserpudding.database.SkillInfoTable
import com.kaiserpudding.model.Role
import com.kaiserpudding.model.SkillInfo
import com.kaiserpudding.model.SkillInfoPrerequisite
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class SkillInfoRepository : AbstractRepository() {

    internal fun get(id: Int): SkillInfo? {
        return SkillInfoTable
            .select { SkillInfoTable.id eq id }
            .limit(1)
            .mapNotNull { toSkillInfo(it) }
            .singleOrNull()
    }

    internal fun get(ids: Iterable<Int>): List<SkillInfo> {
        return SkillInfoTable
            .select { SkillInfoTable.id inList ids }
            .mapNotNull { toSkillInfo(it) }
            .toList()
    }

    fun getAll(): List<SkillInfo> {
        return SkillInfoTable.selectAll().map { toSkillInfo(it) }
    }

    fun getByRole(role: String): List<SkillInfo> {
        return SkillInfoTable
            .select { SkillInfoTable.roleName eq role }
            .mapNotNull { toSkillInfo(it) }
    }

    private fun getPrerequisite(id: Int): List<SkillInfoPrerequisite>? {
        return SkillInfoPrerequisiteTable
            .select { SkillInfoPrerequisiteTable.skillInfoId eq id }
            .map { toPrerequisite(it) }
    }

    private fun toSkillInfo(row: ResultRow) = SkillInfo(
        id = row[SkillInfoTable.id],
        role = Role(row[SkillInfoTable.roleName]),
        name = row[SkillInfoTable.name],
        description = row[SkillInfoTable.description],
        maxLevel = row[SkillInfoTable.maxLevel],
        prerequisites = getPrerequisite(row[SkillInfoTable.id])
    )

    private fun toPrerequisite(row: ResultRow) = SkillInfoPrerequisite(
        id = row[SkillInfoPrerequisiteTable.prerequisiteId],
        level = row[SkillInfoPrerequisiteTable.prerequisiteLevel]
    )


}