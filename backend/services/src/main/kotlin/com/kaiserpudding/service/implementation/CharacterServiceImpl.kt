package com.kaiserpudding.service.implementation

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.queryOptions.CharacterQueryOptions
import com.kaiserpudding.repository.CharacterRepository
import com.kaiserpudding.service.CharacterService

internal class CharacterServiceImpl(private val characterRepository: CharacterRepository) :
    CharacterService {

    override suspend fun create(character: NewCharacter, user: Int): Int = dbQuery {
        characterRepository.create(character, user)
    }

    override suspend fun get(character: Int): CharacterDetail? = dbQuery {
        characterRepository.get(character)
    }

    override suspend fun getAll(): List<CharacterSummary> = dbQuery {
        characterRepository.getAll()
    }

    override suspend fun getBy(options: CharacterQueryOptions): List<CharacterSummary> = dbQuery {
        characterRepository.getBy(options)
    }

    override suspend fun update(characterSummary: CharacterSummary, user: Int): Unit = dbQuery {
        characterRepository.update(characterSummary, user)
    }

    override suspend fun delete(id: Int, user: Int): Boolean = dbQuery {
        characterRepository.delete(id, user)
    }
}