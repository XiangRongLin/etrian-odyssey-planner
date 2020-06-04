package com.kaiserpudding.api.userdata

import com.kaiserpudding.extension.jwtSubject
import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.user(serviceLocator: ServiceLocator) {
    route("api/user") {
        authenticate {
            post("/") {
                call.respond(HttpStatusCode.Created, serviceLocator.userService.create(call.jwtSubject()))
            }
        }
    }
}