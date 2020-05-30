package com.kaiserpudding.service

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.queryOptions.CharacterQueryOptions

interface CharacterService {
    suspend fun create(character: NewCharacter, user: Int): Int

    suspend fun get(character: Int): CharacterDetail?

    suspend fun getAll(): List<CharacterSummary>

    suspend fun getBy(options: CharacterQueryOptions): List<CharacterSummary>

    suspend fun update(characterSummary: CharacterSummary, user: Int)

    suspend fun delete(id: Int, user: Int): Boolean
}