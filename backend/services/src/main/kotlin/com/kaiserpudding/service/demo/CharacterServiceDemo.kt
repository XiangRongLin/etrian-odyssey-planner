package com.kaiserpudding.service.demo

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.service.CharacterService

internal class CharacterServiceDemo : CharacterService {
    override suspend fun create(character: NewCharacter, user: Int): Int {
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

    override suspend fun update(characterSummary: CharacterSummary, user: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int, user: Int): Boolean {
        TODO("Not yet implemented")
    }
}