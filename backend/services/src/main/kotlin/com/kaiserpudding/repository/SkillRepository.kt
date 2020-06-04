package com.kaiserpudding.repository

import com.kaiserpudding.SkillRestrictionException
import com.kaiserpudding.database.SkillTable
import com.kaiserpudding.model.Skill
import org.jetbrains.exposed.sql.*

class SkillRepository : AbstractRepository() {

    /**
     * Does not valide skill integrity
     */
    internal fun create(character: Int, skill: Skill, user: Int) {

        SkillTable.verifyUser(character, user)
            .insert {
                it[skillInfoId] = skill.skillInfoId
                it[level] = skill.level
                it[characterId] = character
            }
    }

    private fun create(character: Int, skill: Skill) {
        SkillTable.insert {
            it[skillInfoId] = skill.skillInfoId
            it[level] = skill.level
            it[characterId] = character
        }
    }

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

    private fun updateLevel(character: Int, skill: Skill): Int {
        return SkillTable.update({ (SkillTable.characterId eq character) and (SkillTable.skillInfoId eq skill.skillInfoId) }) {
            it[level] = skill.level
        }
    }

    fun insertOrUpdate(character: Int, skills: List<Skill>, user: Int) {
        SkillTable.verifyUser(character, user)
        skills.forEach { skill ->
            if (skill.level == 0) {
                delete(character, skill.skillInfoId)
            } else {
                val count = updateLevel(character, skill)
                val exists = count > 0
                if (!exists) {
                    create(character, skill)
                }
            }
        }
        if (!checkSkillValid(character)) {
            throw SkillRestrictionException()
        }
    }

    fun delete(character: Int, skillInfo: Int) {
        SkillTable.deleteWhere { (SkillTable.characterId eq character) and (SkillTable.skillInfoId eq skillInfo) }
    }

    internal fun deleteByCharacter(character: Int) {
        SkillTable.deleteWhere { SkillTable.characterId eq character }
    }

    /**
     * Checks if the skills saved in the database is valid.
     * The level of a skill should not be bigger than the maximum or negative
     * The prerequisites of each skills have to be learned to the minimum level.
     * */
    private fun checkSkillValid(characterId: Int): Boolean {
        val character = CharacterRepository().get(characterId)!!
        val skills = getByCharacter(characterId)
        val skillsMap = skills.map { skill -> skill.skillInfoId to skill }.toMap()
        val skillInfosMap = SkillInfoRepository()
            .get(skills.map { it.skillInfoId }).map { skillInfo -> skillInfo.id to skillInfo }.toMap()

        skills.forEach { skill ->
            val skillInfo = skillInfosMap.getValue(skill.skillInfoId)
            if (character.role != skillInfo.role || skill.level < 0 || skill.level > skillInfo.maxLevel) {
                return false
            }
            skillInfo.prerequisites?.forEach { prerequisite ->
                if (skillsMap.getOrElse(prerequisite.id) { return false }.level < prerequisite.level) {
                    return false
                }
            }
        }
        return true
    }
}