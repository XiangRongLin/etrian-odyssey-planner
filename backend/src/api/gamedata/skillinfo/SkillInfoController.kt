package com.kaiserpudding.api.gamedata.skillinfo

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.skillInfo(service: SkillInfoService) {
    route("api/skill-info") {

        get("/") {
            call.respond(service.getAll())
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Missing id")
            val skillInfo = service.get(id)
            if (skillInfo != null) {
                call.respond(skillInfo)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
    }
}