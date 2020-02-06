package com.kaiserpudding.api.userdata.skill

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.NewSkill
import com.kaiserpudding.model.Skill
import com.kaiserpudding.model.SkillInfoTable
import com.kaiserpudding.model.SkillTable
import org.jetbrains.exposed.sql.*

class SkillService {

    suspend fun create(skill: NewSkill): Int = dbQuery {
        SkillTable.insert {
            it[skillInfoId] = skill.skillInfoId
            it[level] = skill.level
            it[characterId] = skill.characterId
        }[SkillTable.id]
    }

    suspend fun get(id: Int): Skill? = dbQuery {
        SkillTable.select { SkillTable.id eq id }
            .limit(1)
            .mapNotNull { toSkill(it) }
            .singleOrNull()
    }

    /**
     * Returns all skills from the character with given id
     * @return A list of the skills, list is empty if no skills are found
     */
    suspend fun getFromCharacter(id: Int): List<Skill> = dbQuery {
        SkillTable.select { SkillTable.characterId eq id }
            .mapNotNull { toSkill(it) }
    }

    private fun toSkill(row: ResultRow): Skill = Skill(
        id = row[SkillTable.id],
        skillInfoId = row[SkillTable.skillInfoId],
        level = row[SkillTable.level],
        characterId = row[SkillTable.characterId]
    )

    suspend fun update(skill: Skill): Skill? = dbQuery {
        SkillTable.update({ SkillTable.id eq skill.id }) {
            it[skillInfoId] = skill.skillInfoId
            it[level] = skill.level
            it[characterId] = skill.characterId
        }
        get(skill.id)
    }

    suspend fun setLevel(id: Int, newLevel: Int): Skill? = dbQuery {
        val maxLevel = getMaxSkillLevel(id)
        if (maxLevel != null && newLevel > maxLevel) {
            SkillTable.update({ SkillTable.id eq id }) {
                it[level] = newLevel
            }
            get(id)
        } else {
            null
        }
    }

    private suspend fun getMaxSkillLevel(id: Int): Int? = dbQuery {
        SkillTable.innerJoin(SkillInfoTable, { skillInfoId }, { SkillInfoTable.id })
            .slice(SkillInfoTable.maxLevel)
            .select { SkillTable.id eq id }
            .map { it[SkillInfoTable.maxLevel] }
            .singleOrNull()
    }

    suspend fun delete(id: Int): Boolean = dbQuery {
        SkillTable.deleteWhere { SkillTable.id eq id } > 0
    }
}