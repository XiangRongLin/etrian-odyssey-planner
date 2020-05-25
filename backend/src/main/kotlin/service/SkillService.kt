package com.kaiserpudding.service

import com.kaiserpudding.model.NewSkill
import com.kaiserpudding.model.Skill

interface SkillService {
    suspend fun update(character: Int, skills: List<NewSkill>)

    suspend fun getByCharacter(character: Int): List<Skill>
}