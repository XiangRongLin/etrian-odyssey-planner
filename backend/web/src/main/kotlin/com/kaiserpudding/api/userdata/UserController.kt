package com.kaiserpudding.api.userdata

import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.principal
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.user(serviceLocator: ServiceLocator) {
    route("api/user") {
        authenticate("jwt", build = fun Route.() {
            post("/") {

                call.principal<JWTPrincipal>()?.payload?.subject?.let {
                    call.respond(HttpStatusCode.Created, serviceLocator.userService.create(it))
                }
            }
        })
    }
}