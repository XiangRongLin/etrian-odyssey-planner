package com.kaiserpudding.api.gamedata.role

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.role(service: RoleService) {
    route("/api/role") {

        get("/") {
           call.respond(service.getAll())
        }
    }
}