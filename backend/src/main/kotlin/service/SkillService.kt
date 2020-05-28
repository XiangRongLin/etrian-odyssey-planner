package com.kaiserpudding.service

import com.kaiserpudding.model.Skill

interface SkillService {
    suspend fun update(character: Int, skills: List<Skill>, user: Int)

    suspend fun getByCharacter(character: Int): List<Skill>
}