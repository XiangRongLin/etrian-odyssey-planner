package com.kaiserpudding.api.gamedata.role

import io.ktor.application.call
import io.ktor.http.CacheControl
import io.ktor.response.cacheControl
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.role(service: RoleService) {
    route("/api/role") {

        get("/") {
            call.response.cacheControl(
                CacheControl.MaxAge(
                    60 * 60 * 24 * 30,
                    visibility = CacheControl.Visibility.Public
                )
            )
            call.respond(service.getAll())
        }
    }
}