package com.kaiserpudding.repository

import com.kaiserpudding.database.CharacterTable
import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.Role
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class CharacterRepository : AbstractRepository() {

    fun create(character: NewCharacter, user: Int): Int = CharacterTable.insert {
        it[name] = character.name
        it[role] = character.role
        it[userId] = user
    }[CharacterTable.id]

    fun getAll(): List<CharacterSummary> = CharacterTable.selectAll().map { toCharacterSummary(it) }

    fun get(id: Int): CharacterDetail? = CharacterTable.select { CharacterTable.id eq id }
        .limit(1)
        .mapNotNull { toCharacterDetail(it) }
        .singleOrNull()

    fun getNonNullable(id: Int): CharacterSummary {
        return CharacterTable.select { CharacterTable.id eq id }
            .limit(1)
            .map { toCharacterSummary(it) }
            .single()
    }

    fun getByName(name: String): List<CharacterSummary> {
        return CharacterTable.select { CharacterTable.name.like("%$name%") }
            .map { toCharacterSummary(it) }
    }

    private fun toCharacterSummary(row: ResultRow) = CharacterSummary(
        id = row[CharacterTable.id],
        name = row[CharacterTable.name],
        role = Role(row[CharacterTable.role])
    )

    private fun toCharacterDetail(row: ResultRow) = CharacterDetail(
        id = row[CharacterTable.id],
        name = row[CharacterTable.name],
        role = Role(row[CharacterTable.role]),
        skills = SkillRepository().getByCharacter(row[CharacterTable.id])
    )

    fun update(characterSummary: CharacterSummary, user: Int) {
        CharacterTable.verifyUser(characterSummary.id, user)
            .update({ CharacterTable.id eq characterSummary.id }) {
                it[name] = characterSummary.name
            }
    }

    fun delete(id: Int, user: Int): Boolean {
        return CharacterTable.verifyUser(id, user)
            .deleteWhere {
                (CharacterTable.id eq id) and (CharacterTable.userId eq user)
            } > 0
    }
}