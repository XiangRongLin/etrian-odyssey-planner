package com.kaiserpudding.database

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.configuration.FluentConfiguration
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*

object DatabaseMigrations {
    fun migrate() {
        val flyway = Flyway.configure()
            .dataSource("/config/hikari.properties")
            .schemas("public")
            .locations("migration/postgresql")
            .load()
        flyway.migrate()
    }

    fun FluentConfiguration.dataSource(path: String): FluentConfiguration {
        val uri = DatabaseMigrations::class.java.getResource(path)
        val file = File(uri.file)
        try {

            val fis = if (file.isFile) FileInputStream(file) else javaClass.getResourceAsStream(path)
            if (fis != null) {
                val properties = Properties()
                properties.load(fis)
                val url = properties.getProperty("dataSource.serverName")
                val port = properties.getProperty("dataSource.portNumber")
                val database = properties.getProperty("dataSource.databaseName")
                val user = properties.getProperty("dataSource.user")
                val password = properties.getProperty("dataSource.password")
                return this.dataSource(
                    "jdbc:postgresql://$url:$port/$database",
                    user,
                    password
                )
            } else {
                throw IllegalArgumentException("Cannot find property file: $path")
            }

        } catch (e: IOException) {
            throw RuntimeException("Failed to read property file", e)
        }
    }
}