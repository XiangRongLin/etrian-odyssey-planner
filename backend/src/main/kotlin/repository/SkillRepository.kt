package com.kaiserpudding.repository

import com.kaiserpudding.database.SkillTable
import com.kaiserpudding.model.Skill
import com.kaiserpudding.model.SkillInfo
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

class SkillRepository : AbstractRepository() {

    internal fun create(character: Int, skill: Skill) {
        val skillInfo = SkillInfoRepository().get(skill.skillInfoId)
        if (skillInfo == null || skill.level > skillInfo.maxLevel) {
            throw IllegalStateException()
        }

        SkillTable.insert {
            it[skillInfoId] = skill.skillInfoId
            it[level] = skill.level
            it[characterId] = character
        }
    }

//    fun get(id: Int): Skill? {
//        return SkillTable.select { SkillTable.id eq id }
//            .limit(1)
//            .mapNotNull { toSkill(it) }
//            .singleOrNull()
//    }

    /**
     * Returns all skills from the character with given id
     * @return A list of the skills, list is empty if no skills are found
     */
    fun getByCharacter(character: Int): List<Skill> {
        return SkillTable.select { SkillTable.characterId eq character }
            .mapNotNull { toSkill(it) }
    }

    private fun toSkill(row: ResultRow): Skill =
        Skill(
            skillInfoId = row[SkillTable.skillInfoId],
            level = row[SkillTable.level]
        )

    private fun updateLevel(character: Int, skill: Skill) =
        SkillTable.update({ (SkillTable.characterId eq character) and (SkillTable.skillInfoId eq skill.skillInfoId) }) {
            it[level] = skill.level
        }

    fun insertOrUpdate(character: Int, skills: List<Skill>) {
        skills.forEach { skill ->
            val exists = updateLevel(character, skill) > 0
            if (!exists) {
                create(character, skill)
            }
        }
        if (!checkSkillValid(character)) {
            throw IllegalStateException("Skill prerequisites are not fulfilled")
        }

    }

    /**
     * Checks if the skills saved in the database is valid.
     * The level of a skill should not be bigger than the maximum or negative
     * The prerequisites of each skills have to be learned to the minimum level.
     * */
    private fun checkSkillValid(character: Int): Boolean {
//        val skills = getByCharacter(character)
//        val skillsMap = skills.map { skill -> skill.id to skill }.toMap()
//        val skillInfosMap =
//            SkillInfoRepository()
//                .get(skills.map { it.skillInfoId }).map { skillInfo -> skillInfo.id to skillInfo }.toMap()
//
//        skills.forEach { skill ->
//            val skillInfo = skillInfosMap.getValue(skill.skillInfoId)
//            if (skill.level < 0 || skill.level > skillInfo.maxLevel) {
//                return false
//            }
//            skillInfo.prerequisites?.forEach { prerequisite ->
//                if (skillsMap.getOrElse(prerequisite.id) { return false }.level < prerequisite.level) {
//                    return false
//                }
//            }
//        }
        return true
    }


    private fun validSkillLevel(skill: Skill, skillInfo: SkillInfo) = skill.level >= skillInfo.maxLevel

    internal fun deleteAll() = SkillTable.deleteAll()

}