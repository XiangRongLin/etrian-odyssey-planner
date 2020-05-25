package com.kaiserpudding.repository

import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.NewSkill
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction


internal abstract class AbstractRepositoryTest {
    private val jdbcUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false"

    companion object {
        private var initialized = false
    }

    protected fun <T> dbTest(block: () -> T) {
        if (!initialized) {
            initDatabase()
        }
        transaction {
            SchemaUtils.setSchema(Schema("mem"))
            block()
            TransactionManager.current().rollback()
        }
    }

    private fun initDatabase() {
        Database.connect(jdbcUrl, "org.h2.Driver")
        val flyway = Flyway.configure()
            .dataSource(jdbcUrl, "", "")
            .schemas("mem")
            .locations("database/migration/h2")
            .load()
        flyway.migrate()
        initUserData()

        initialized = true
    }

    private fun initUserData() = transaction {
        SchemaUtils.setSchema(Schema("mem"))
        val characterRepository = CharacterRepository()
        val skillRepository = SkillRepository()
        val character = characterRepository.create(NewCharacter("name", "Hero"))
        skillRepository.create(character, NewSkill(null, 2, 2))
    }

}
