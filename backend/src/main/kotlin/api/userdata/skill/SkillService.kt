package com.kaiserpudding.api.userdata.skill

import com.kaiserpudding.api.AbstractService
import com.kaiserpudding.api.gamedata.skillinfo.SkillInfoService
import com.kaiserpudding.database.SkillTable
import com.kaiserpudding.extension.upsert
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class SkillService(schema: Schema? = null) : AbstractService(schema) {

    suspend fun get(id: Int): Skill? = dbQuery {
        SkillTable.select { SkillTable.id eq id }
            .limit(1)
            .mapNotNull { toSkill(it) }
            .singleOrNull()
    }

    suspend fun create(character: Int, skill: NewSkill): Int = dbQuery {
        SkillTable.insert {
            it[skillInfoId] = skill.skillInfoId
            it[level] = skill.level
            it[characterId] = character
        }[SkillTable.id]
    }

    /**
     * Returns all skills from the character with given id
     * @return A list of the skills, list is empty if no skills are found
     */
    suspend fun getFromCharacter(id: Int): List<Skill> = dbQuery {
        SkillTable.select { SkillTable.characterId eq id }
            .mapNotNull { toSkill(it) }
    }

    private fun toSkill(row: ResultRow): Skill =
        Skill(
            id = row[SkillTable.id],
            skillInfoId = row[SkillTable.skillInfoId],
            level = row[SkillTable.level]
        )

    suspend fun updateSkills(character: Int, skills: List<NewSkill>) = dbQuery {
        skills.forEach { skill ->
            SkillTable.upsert(SkillTable.id) {
                it[skillInfoId] = skill.skillInfoId
                it[level] = skill.level
                it[characterId] = character
            }
        }
        if (!checkSkillValid(character)) {
            throw IllegalStateException("Skill prerequisites are not fulfilled")
        }

    }

    /**
     * Checks if the skills saved in the database is valid.
     * The prerequisites of each skills have to be learned to the minimum level.
     * */
    private suspend fun checkSkillValid(character: Int): Boolean {
        val skills = getFromCharacter(character)
        val skillsMap = skills.map { skill -> skill.id to skill }.toMap()
        val skillInfosMap =
            SkillInfoService().get(skills.map { it.skillInfoId }).map { skillInfo -> skillInfo.id to skillInfo }.toMap()

        skills.forEach { skill ->
            skillInfosMap.getValue(skill.skillInfoId).prerequisites?.forEach { prerequisite ->
                if (skillsMap.getOrElse(prerequisite.id) { return false }.level < prerequisite.level) {
                    return false
                }
            }
        }
        return true
    }

    internal suspend fun deleteAll() = dbQuery {
        SkillTable.deleteAll()
    }
}