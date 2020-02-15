package com.kaiserpudding.api.userdata.character

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Character
import com.kaiserpudding.model.CharacterTable
import com.kaiserpudding.model.NewCharacter
import org.jetbrains.exposed.sql.*

class CharacterService {

    suspend fun create(character: NewCharacter): Int = dbQuery {
        CharacterTable.insert {
            it[name] = character.name
        }[CharacterTable.id]
    }

    suspend fun getAll(): List<Character> = dbQuery {
        CharacterTable.selectAll().map { toCharacter(it) }
    }

    suspend fun get(id: Int): Character? = dbQuery {
        CharacterTable.select { CharacterTable.id eq id }
            .limit(1)
            .mapNotNull { toCharacter(it) }
            .singleOrNull()
    }

    suspend fun searchBy(name: String): List<Character> = dbQuery {
        CharacterTable.select { CharacterTable.name.like("%$name%") }
            .map { toCharacter(it) }
    }

    private fun toCharacter(row: ResultRow): Character = Character(
        id = row[CharacterTable.id],        name = row[CharacterTable.name]
    )

    suspend fun update(character: Character): Character? = dbQuery {
        CharacterTable.update({ CharacterTable.id eq character.id }) {
            it[name] = character.name
        }
        get(character.id)
    }

    suspend fun delete(id: Int): Boolean = dbQuery {
        CharacterTable.deleteWhere { CharacterTable.id eq id } > 0
    }
}