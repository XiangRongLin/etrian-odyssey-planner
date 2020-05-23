package com.kaiserpudding.api.gamedata.skillinfo

import com.kaiserpudding.api.gamedata.role.Role
import io.ktor.application.call
import io.ktor.http.CacheControl
import io.ktor.response.cacheControl
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.skillInfo(service: SkillInfoService) {
    route("api/skill-info") {

        get("/") {
            val role: String? = call.parameters["role"]
            call.response.cacheControl(CacheControl.MaxAge(60 * 60 * 24, visibility = CacheControl.Visibility.Public))
            if (role == null) {
                call.respond(service.getAll())
            } else {
                call.respond(service.getByRole(Role(role)))
            }
        }
    }
}