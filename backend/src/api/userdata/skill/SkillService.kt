package com.kaiserpudding.api.userdata.skill

import com.kaiserpudding.api.gamedata.skillinfo.SkillInfoService
import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.database.SkillTable
import com.kaiserpudding.extension.upsert
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select

class SkillService {

//    suspend fun get(id: Int): Skill? = dbQuery {
//        SkillTable.select { SkillTable.id eq id }
//            .limit(1)
//            .mapNotNull { toSkill(it) }
//            .singleOrNull()
//    }

    /**
     * Returns all skills from the character with given id
     * @return A list of the skills, list is empty if no skills are found
     */
    suspend fun getFromCharacter(id: Int): List<Skill> = dbQuery {
        SkillTable.select { SkillTable.characterId eq id }
            .mapNotNull { toSkill(it) }
    }


    //    suspend fun update(skill: Skill): Skill? = dbQuery {
//        SkillTable.update({ SkillTable.id eq skill.id }) {
//            it[skillInfoId] = skill.skillInfoId
//            it[level] = skill.level
//            it[characterId] = skill.characterId
//        }
//        get(skill.id)
//    }
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
//
//    private suspend fun getMaxSkillLevel(id: Int): Int? = dbQuery {
//        SkillTable.innerJoin(SkillInfoTable, { skillInfoId }, { SkillInfoTable.id })
//            .slice(SkillInfoTable.maxLevel)
//            .select { SkillTable.id eq id }
//            .map { it[SkillInfoTable.maxLevel] }
//            .singleOrNull()
//    }
//
//    suspend fun delete(id: Int): Boolean = dbQuery {
//        SkillTable.deleteWhere { SkillTable.id eq id } > 0
//    }
}