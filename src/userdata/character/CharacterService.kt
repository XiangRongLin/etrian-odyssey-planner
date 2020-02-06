package com.kaiserpudding.userdata.character

import com.kaiserpudding.database.DatabaseFactory.dbQuery
import com.kaiserpudding.model.Character
import com.kaiserpudding.model.Characters
import com.kaiserpudding.model.NewCharacter
import org.jetbrains.exposed.sql.*

class CharacterService {

    suspend fun create(character: NewCharacter): Int = dbQuery {
        Characters.insert {
            it[name] = character.name
        }[Characters.id]
    }

    suspend fun getAll(): List<Character> = dbQuery {
        Characters.selectAll().map { toCharacter(it) }
    }

    suspend fun get(id: Int): Character? = dbQuery {
        Characters.select { Characters.id eq id }
            .mapNotNull { toCharacter(it) }
            .singleOrNull()
    }

    private fun toCharacter(row: ResultRow): Character = Character(
        id = row[Characters.id],
        name = row[Characters.name]
    )

    suspend fun update(character: Character): Character? = dbQuery {
        Characters.update({ Characters.id eq character.id }) {
            it[name] = character.name
        }
        get(character.id)
    }

    suspend fun delete(id: Int): Boolean = dbQuery {
        Characters.deleteWhere { Characters.id eq id } > 0
    }
}