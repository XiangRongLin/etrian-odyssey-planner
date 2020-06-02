package com.kaiserpudding.service

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.queryOptions.CharacterQueryOptions

interface CharacterService {
    suspend fun create(character: NewCharacter, jwtSubject: String): Int

    suspend fun get(character: Int): CharacterDetail?

    suspend fun getAll(): List<CharacterSummary>

    suspend fun getBy(options: CharacterQueryOptions): List<CharacterSummary>

    suspend fun update(characterSummary: CharacterSummary, jwtSubject: String)

    suspend fun delete(id: Int, jwtSubject: String): Boolean
}