package com.kaiserpudding.userdata.character

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
            .mapNotNull { toCharacter(it) }
            .singleOrNull()
    }

    private fun toCharacter(row: ResultRow): Character = Character(
        id = row[CharacterTable.id],
        name = row[CharacterTable.name]
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