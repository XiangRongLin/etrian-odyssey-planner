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
import com.kaiserpudding.model.User
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

internal abstract class AbstractRepositoryTest {
    private val jdbcUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false"

    protected val user: User
        get() = Companion.user
    protected val party: Party
        get() = Companion.party
    protected val character: CharacterDetail
        get() = Companion.character

    companion object {
        private var initialized = false
        private lateinit var user: User
        private lateinit var party: Party
        private lateinit var character: CharacterDetail
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
            .locations("migration/h2")
            .load()
        flyway.migrate()
        initUserData()

        initialized = true
    }

    private fun initUserData() = transaction {
        SchemaUtils.setSchema(Schema("mem"))
        val userRepository = UserRepository()
        val partyRepository = PartyRepository()
        val characterRepository = CharacterRepository()
        val skillRepository = SkillRepository()

        val userId = userRepository.create()
        Companion.user = User(userId)

        val newParty = NewParty("Dead End")
        val partyId = partyRepository.create(newParty, userId)

        val newCharacter = NewCharacter("name", "Hero")
        val characterId = characterRepository.create(newCharacter, userId)

        val skill = Skill(2, 2)
        skillRepository.create(characterId, skill, userId)

        val newMember = NewPartyMember(characterId, Position.FRONT_MIDDLE)
        partyRepository.createMember(partyId, newMember, userId)

        Companion.party = Party(
            partyId,
            newParty.name,
            listOf(PartyMember(CharacterSummary(characterId, newCharacter), newMember.position))
        )
        Companion.character = CharacterDetail(
            characterId,
            newCharacter.name,
            newCharacter.role,
            listOf(skill)
        )
    }

}
