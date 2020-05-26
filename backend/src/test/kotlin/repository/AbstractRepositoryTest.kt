package com.kaiserpudding.repository

import com.kaiserpudding.model.CharacterDetail
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.Party
import com.kaiserpudding.model.PartyMember
import com.kaiserpudding.model.Position
import com.kaiserpudding.model.Skill
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction


internal abstract class AbstractRepositoryTest {
    private val jdbcUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false"

    protected lateinit var party: Party
    protected lateinit var character: CharacterDetail

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
        val partyRepository = PartyRepository()
        val characterRepository = CharacterRepository()
        val skillRepository = SkillRepository()

        val newParty = NewParty("Dead End")
        val partyId = partyRepository.create(newParty)

        val newCharacter = NewCharacter("name", "Hero")
        val characterId = characterRepository.create(newCharacter)

        val skill = Skill(2, 2)
        skillRepository.create(characterId, skill)

        val newMember = NewPartyMember(characterId, Position.FRONT_MIDDLE)
        partyRepository.createMember(partyId, newMember)

        party = Party(
            partyId,
            newParty.name,
            listOf(PartyMember(CharacterSummary(characterId, newCharacter), newMember.position))
        )
        character = CharacterDetail(
            characterId,
            newCharacter.name,
            newCharacter.role,
            listOf(skill)
        )
    }

}
