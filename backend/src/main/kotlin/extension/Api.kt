package com.kaiserpudding.extension

import io.ktor.application.ApplicationCall

fun ApplicationCall.getIntParameter(name: String): Int = checkNotNull(this.parameters[name]).toInt()

