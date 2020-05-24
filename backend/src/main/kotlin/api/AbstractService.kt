package com.kaiserpudding.api

import org.jetbrains.exposed.sql.Schema
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

abstract class AbstractService(private val schema: Schema? = null) {
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction {
            schema?.let { SchemaUtils.setSchema(it) }
            block()
        }
}