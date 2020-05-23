package com.kaiserpudding.api.userdata.character

import com.kaiserpudding.database.CharacterTable
import com.kaiserpudding.database.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class CharacterService {

    suspend fun create(character: NewCharacter): Int = dbQuery {
        CharacterTable.insert {
            it[name] = character.name
            it[role] = character.role
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

    private fun toCharacter(row: ResultRow): Character =
        Character(
            id = row[CharacterTable.id],
            name = row[CharacterTable.name],
            role = row[CharacterTable.role]
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