package com.kaiserpudding.repository

import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

abstract class AbstractRepository(private val schema: Schema? = null) {
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction {
            schema?.let { SchemaUtils.setSchema(it) }
            block()
        }
}