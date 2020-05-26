package com.kaiserpudding.service

import com.kaiserpudding.model.Skill

interface SkillService {
    suspend fun update(character: Int, skills: List<Skill>)

    suspend fun getByCharacter(character: Int): List<Skill>
}