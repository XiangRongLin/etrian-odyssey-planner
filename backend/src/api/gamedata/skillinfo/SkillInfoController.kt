package com.kaiserpudding.api.gamedata.skillinfo

import com.kaiserpudding.api.gamedata.role.Role
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.skillInfo(service: SkillInfoService) {
    route("api/skill-info") {

        get("/") {
            val role: String? = call.parameters["role"]
            if (role == null) {
                call.respond(service.getAll())
            } else {
                call.respond(service.getByRole(Role(role)))
            }
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