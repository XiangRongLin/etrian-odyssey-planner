package com.kaiserpudding.service.demo

import com.kaiserpudding.model.Skill
import com.kaiserpudding.service.SkillService

class SkillServiceDemo : SkillService {
    override suspend fun update(character: Int, skills: List<Skill>, user: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getByCharacter(character: Int): List<Skill> {
        TODO("Not yet implemented")
    }
}