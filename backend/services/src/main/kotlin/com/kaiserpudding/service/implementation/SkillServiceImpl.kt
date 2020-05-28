package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Skill
import com.kaiserpudding.repository.SkillRepository
import com.kaiserpudding.service.SkillService

class SkillServiceImpl(private val skillRepository: SkillRepository) : SkillService {
    override suspend fun update(character: Int, skills: List<Skill>, user: Int): Unit = dbQuery {
        skillRepository.insertOrUpdate(character, skills, user)
    }

    override suspend fun getByCharacter(character: Int): List<Skill> = dbQuery {
        skillRepository.getByCharacter(character)
    }
}