package com.kaiserpudding.repository

import com.kaiserpudding.UserAccessException
import com.kaiserpudding.database.CharacterTable
import com.kaiserpudding.database.PartyMemberTable
import com.kaiserpudding.database.PartyTable
import com.kaiserpudding.database.SkillTable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select

private fun PartyTable.hasAccess(party: Int, user: Int): Boolean {
    return slice(userId)
        .select { (id eq party) and (userId eq user) }
        .singleOrNull()?.get(userId) == user
}

fun PartyTable.verifyUser(party: Int, user: Int): PartyTable {
    return if (hasAccess(party, user)) this else throw UserAccessException()
}

fun PartyMemberTable.verifyUser(party: Int, user: Int): PartyMemberTable {
    return if (PartyTable.hasAccess(party, user)) this else throw UserAccessException()
}

private fun CharacterTable.hasAccess(character: Int, user: Int): Boolean {
    return slice(userId)
        .select { (id eq character) and (userId eq user) }
        .singleOrNull()?.get(userId) == user
}

fun CharacterTable.verifyUser(character: Int, user: Int): CharacterTable {
    return if (hasAccess(character, user)) this else throw UserAccessException()
}

fun SkillTable.verifyUser(character: Int, user: Int): SkillTable {
    return if (CharacterTable.hasAccess(character, user)) this else throw UserAccessException()
}