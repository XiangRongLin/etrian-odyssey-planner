package com.kaiserpudding.service

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.NewSkill
import com.kaiserpudding.model.Skill

interface CharacterService {
    suspend fun create(character: NewCharacter): Int

    suspend fun get(character: Int): CharacterDetail?

    suspend fun getAll(): List<CharacterSummary>

    suspend fun getByName(name: String): List<CharacterSummary>

    suspend fun update(characterSummary: CharacterSummary)

    suspend fun delete(id: Int): Boolean

    suspend fun getSkillsByCharacter(character: Int): List<Skill>

    suspend fun updateSkills(character: Int, skills: List<NewSkill>)
}