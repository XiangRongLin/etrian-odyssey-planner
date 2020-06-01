package com.kaiserpudding.service.demo

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.queryOptions.CharacterQueryOptions
import com.kaiserpudding.service.CharacterService

internal class CharacterServiceDemo : CharacterService {
    override suspend fun create(character: NewCharacter, jwtId: String): Int {
        TODO("Not yet implemented")
    }

    override suspend fun get(character: Int): CharacterDetail? {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<CharacterSummary> {
        TODO("Not yet implemented")
    }

    override suspend fun getBy(options: CharacterQueryOptions): List<CharacterSummary> {
        TODO("Not yet implemented")
    }

    override suspend fun update(characterSummary: CharacterSummary, jwtId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int, jwtId: String): Boolean {
        TODO("Not yet implemented")
    }
}