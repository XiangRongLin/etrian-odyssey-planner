package com.kaiserpudding.extension

import io.ktor.application.ApplicationCall
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.principal

fun ApplicationCall.getIntParameter(name: String): Int = checkNotNull(this.parameters[name]).toInt()
fun ApplicationCall.getStringParameter(name: String): String = checkNotNull(this.parameters[name])
fun ApplicationCall.jwtSubject(): String {
    val principal = principal<JWTPrincipal>()
        ?: throw IllegalStateException("Method was not called inside a jwt authentication block")
    return principal.payload.subject
}

