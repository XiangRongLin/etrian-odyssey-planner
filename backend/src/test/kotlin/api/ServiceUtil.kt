package com.kaiserpudding.api

import com.kaiserpudding.api.userdata.character.NewCharacter
import com.kaiserpudding.api.userdata.skill.NewSkill
import com.kaiserpudding.repository.AbstractRepository
import com.kaiserpudding.repository.CharacterRepository
import com.kaiserpudding.repository.PartyRepository
import com.kaiserpudding.repository.SkillRepository
import kotlinx.coroutines.runBlocking
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Schema

private const val JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false"
private var initialized = false


fun initDatabase() {
    if (!initialized) {
        Database.connect(JDBC_URL, "org.h2.Driver")
        val flyway = Flyway.configure()
            .dataSource(JDBC_URL, "", "")
            .schemas("mem")
            .locations("database/migration/h2")
            .load()
        flyway.migrate()
        initialized = true
    }
}

fun initUserData() {
    runBlocking {
        val characterService = getRepository(CharacterRepository::class.java)
        val skillService = getRepository(SkillRepository::class.java)
        val character = characterService.create(NewCharacter("name", "Hero"))
        skillService.create(character, NewSkill(null, 2, 2))
    }
}

fun clearUserData() {
    runBlocking {
        val characterService = getRepository(CharacterRepository::class.java)
        val skillService = getRepository(SkillRepository::class.java)
        val partyService = getRepository(PartyRepository::class.java)
        characterService.deleteAll()
        skillService.deleteAll()
        partyService.deleteAll()
    }
}

fun <T : AbstractRepository> getRepository(clazz: Class<T>): T {
    val schema = Schema("mem")
    return clazz.getConstructor(schema::class.java).newInstance(schema)
}

fun <T> dbTest(block: suspend () -> T): T = runBlocking {
    block()
}