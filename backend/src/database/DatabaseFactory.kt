package com.kaiserpudding.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object DatabaseFactory {

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction { block() }

    fun init() {
        val config = HikariConfig("resources/database/config/hikari.properties")
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
    }

}