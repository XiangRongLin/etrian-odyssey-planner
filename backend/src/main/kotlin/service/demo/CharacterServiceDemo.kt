package com.kaiserpudding.service.demo

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.NewSkill
import com.kaiserpudding.model.Skill
import com.kaiserpudding.service.CharacterService

internal class CharacterServiceDemo : CharacterService {
    override suspend fun create(character: NewCharacter): Int {
        TODO("Not yet implemented")
    }

    override suspend fun get(character: Int): CharacterDetail? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<CharacterSummary> {
        TODO("Not yet implemented")
    }

    override suspend fun getByName(name: String): List<CharacterSummary> {
        TODO("Not yet implemented")
    }

    override suspend fun update(characterSummary: CharacterSummary) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getSkillsByCharacter(character: Int): List<Skill> {
        TODO("Not yet implemented")
    }

    override suspend fun updateSkills(character: Int, skills: List<NewSkill>) {
        TODO("Not yet implemented")
    }
}