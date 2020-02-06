package com.kaiserpudding.database

import com.kaiserpudding.model.CharacterTable
import com.kaiserpudding.model.RoleTable
import com.kaiserpudding.model.SkillInfoPrerequisiteTable
import com.kaiserpudding.model.SkillInfoTable
import com.kaiserpudding.gamedata.role.RoleService
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.nio.file.Files
import java.nio.file.Paths

object DatabaseFactory {

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction { block() }

    suspend fun init() {
        val config = HikariConfig("resources/hikari.properties")
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
        dbQuery {
            SchemaUtils.drop(CharacterTable, RoleTable, SkillInfoTable, SkillInfoPrerequisiteTable)
            initCharacters()
            initRoles()
            initSkillInfo()
        }
    }

    private suspend fun initCharacters() {
        SchemaUtils.create(CharacterTable)
    }

    private suspend fun initRoles() {
        SchemaUtils.create(RoleTable)
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
        SchemaUtils.create(SkillInfoTable)
        SchemaUtils.create(SkillInfoPrerequisiteTable)
        val connection = TransactionManager.current().connection
        val statement = connection.createStatement()
        withContext(Dispatchers.IO) {
            val reader = Files.newBufferedReader(Paths.get("src/database/init/skills.sql"))
            reader.lines().forEach { query ->
                statement.execute(query)
            }
        }

    }
}