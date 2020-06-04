package com.kaiserpudding.repository

import com.kaiserpudding.database.CharacterTable
import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.Role
import com.kaiserpudding.queryOptions.CharacterQueryOptions
import org.jetbrains.exposed.sql.*

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

    internal fun getNonNullable(id: Int): CharacterSummary {
        return CharacterTable.select { CharacterTable.id eq id }
            .limit(1)
            .map { toCharacterSummary(it) }
            .single()
    }

    fun getBy(queryOptions: CharacterQueryOptions): List<CharacterSummary> {
        val where: SqlExpressionBuilder.() -> Op<Boolean> = {
            val filters: MutableList<Op<Boolean>> = mutableListOf()
            queryOptions.name?.let {
                filters.add(CharacterTable.name.lowerCase() like "%${it.toLowerCase()}%")
            }
            queryOptions.role?.let {
                filters.add(CharacterTable.role eq it)
            }
            queryOptions.user?.let {
                filters.add(CharacterTable.userId eq it)
            }
            var expression: Op<Boolean> = Op.TRUE
            filters.forEach { op ->
                expression = expression and op
            }
            expression
        }

        return CharacterTable.select(where).map { toCharacterSummary(it) }
    }

    private fun toCharacterSummary(row: ResultRow) = CharacterSummary(
        id = row[CharacterTable.id],
        name = row[CharacterTable.name],
        role = row[CharacterTable.role]
    )

    private fun toCharacterDetail(row: ResultRow) = CharacterDetail(
        id = row[CharacterTable.id],
        name = row[CharacterTable.name],
        role = Role(row[CharacterTable.role]),
        skills = SkillRepository().getByCharacter(row[CharacterTable.id])
    )

    fun update(characterSummary: CharacterSummary, user: Int) {
        val oldUser = get(characterSummary.id) ?: return
        CharacterTable.verifyUser(characterSummary.id, user)
            .update({ CharacterTable.id eq characterSummary.id }) {
                it[name] = characterSummary.name
                it[role] = characterSummary.role.name
            }

        if (oldUser.role != characterSummary.role) {
            SkillRepository().deleteByCharacter(characterSummary.id)
        }
    }

    fun delete(id: Int, user: Int): Boolean {
        return CharacterTable.verifyUser(id, user)
            .deleteWhere {
                (CharacterTable.id eq id) and (CharacterTable.userId eq user)
            } > 0
    }
}