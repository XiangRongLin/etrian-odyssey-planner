package com.kaiserpudding.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {

    fun init() {
        val config = HikariConfig("src/main/resources/database/config/hikari.properties")
        val dataSource = HikariDataSource(config)
        Database.connect(dataSource)
    }

}