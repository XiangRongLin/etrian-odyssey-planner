package com.kaiserpudding.database

import com.kaiserpudding.api.gamedata.role.RoleService
import com.kaiserpudding.api.userdata.character.CharacterService
import com.kaiserpudding.api.userdata.party.PartyService
import com.kaiserpudding.model.*
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.nio.file.Files
import java.nio.file.Paths

object DatabaseFactory {

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction { block() }

    suspend fun init() {
        val config = HikariConfig("resources/hikari.properties")
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)

//        dbQuery {
//            SchemaUtils.drop(
//                CharacterTable,
//                RoleTable,
//                SkillInfoTable,
//                SkillInfoPrerequisiteTable,
//                PartyTable,
//                PartyMemberTable
//            )
//            initSchema()
//
//            initCharacters()
//            initRoles()
//            initSkillInfo()
//            initSkill()
//            initParty()
//        }
    }

    private fun initSchema() {
        SchemaUtils.create(CharacterTable)
        SchemaUtils.create(RoleTable)
        SchemaUtils.create(SkillInfoTable)
        SchemaUtils.create(SkillInfoPrerequisiteTable)
        SchemaUtils.create(SkillTable)
        SchemaUtils.create(PartyTable)
        SchemaUtils.create(PartyMemberTable)
    }

    private suspend fun initCharacters() {
        val service = CharacterService()
        service.create(NewCharacter(null, name = "Ori"))
        service.create(NewCharacter(null, "braum"))
        service.create(NewCharacter(null, "vayne"))
    }

    private suspend fun initRoles() {
        val roles = listOf(
            "Protector",
            "Survivalist",
            "Medic",
            "Ronin",
            "War Magus",
            "Gunner",
            "Zodiac",
            "Farmer",
            "Ninja",
            "Sovereign",
            "Shogun",
            "Nightseeker",
            "Landsknecht",
            "Arcanist",
            "Imperial",
            "Highlander",
            "Harbinger",
            "Pugilist",
            "Hero",
            "Vampire"
        )
        RoleService().insertAll(roles)
    }

    private suspend fun initSkillInfo() {
        val connection = TransactionManager.current().connection
        val statement = connection.createStatement()
        withContext(Dispatchers.IO) {
            val reader = Files.newBufferedReader(Paths.get("sql/skills.sql"))
            reader.lines().forEach { query ->
                statement.execute(query)
            }
        }
    }

    private suspend fun initSkill() {
    }

    private suspend fun initParty() {
        val service = PartyService()
        service.create(NewParty(null, "Death End"))
        service.create(NewParty(null, "party 2"))
        PartyService().addMember(PartyMember(1, 1, Position.BACK_LEFT))
        PartyService().addMember(PartyMember(1, 2, Position.FRONT_LEFT))
        PartyService().addMember(PartyMember(1, 3, Position.BACK_RIGHT))
    }

}