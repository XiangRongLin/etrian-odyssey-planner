package com.kaiserpudding.api

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.util.pipeline.PipelineContext
import java.lang.IllegalStateException
import java.lang.NumberFormatException

/**
 * Executes given block.
 *
 * Responds the call with [HttpStatusCode.NotFound] if [IllegalStateException] or [NumberFormatException]
 * gets thrown
 */
suspend fun PipelineContext<Unit, ApplicationCall>.request(block: suspend () -> Unit) {
    try {
        block()
    } catch (e: NumberFormatException) {
        call.respond(HttpStatusCode.NotFound)
    } catch (e: IllegalStateException) {
        call.respond(HttpStatusCode.NotFound)
    }
}