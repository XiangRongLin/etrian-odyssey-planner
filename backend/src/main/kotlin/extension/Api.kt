package com.kaiserpudding.extension

import io.ktor.application.ApplicationCall

fun ApplicationCall.getIntParameter(name: String): Int = checkNotNull(this.parameters[name]).toInt()
fun ApplicationCall.getStringParameter(name: String): String = checkNotNull(this.parameters[name])

