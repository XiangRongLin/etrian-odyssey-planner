package com.kaiserpudding.gamedata.role

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.role(repository: RoleRepository) {
    route("/api/role") {

        get("/") {
           call.respond(RoleRepository.getAll())
        }
    }
}