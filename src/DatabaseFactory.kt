package com.kaiserpudding

import com.kaiserpudding.model.Characters
import com.kaiserpudding.model.Roles
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.batchInsert
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction { block() }

    fun init() {
        val config = HikariConfig("resources/hikari.properties")
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
        transaction {
            initCharacters()
            initRoles()
        }
    }

    private fun initCharacters() {
        SchemaUtils.create(Characters)
        Characters.insert {
            it[name] = "Ori"
        }
    }

    private fun initRoles() {
        SchemaUtils.create(Roles)
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
        Roles.batchInsert(roles) {
            this[Roles.name] = it
        }
    }
}