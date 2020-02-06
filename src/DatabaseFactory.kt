package com.kaiserpudding

import com.kaiserpudding.model.Characters
import com.kaiserpudding.model.Roles
import com.kaiserpudding.role.RoleService
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object DatabaseFactory {

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction { block() }

    suspend fun init() {
        val config = HikariConfig("resources/hikari.properties")
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
        dbQuery {
//            initCharacters()
//            initRoles()
        }
    }

    private suspend fun initCharacters() {
        SchemaUtils.create(Characters)
    }

    private suspend fun initRoles() {
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
        RoleService().insertAll(roles)
    }
}