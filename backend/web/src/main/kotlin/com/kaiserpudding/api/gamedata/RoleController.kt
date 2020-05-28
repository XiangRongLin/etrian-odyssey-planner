package com.kaiserpudding.api.gamedata

import com.kaiserpudding.extension.getStringParameter
import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.http.CacheControl
import io.ktor.response.cacheControl
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.role(serviceLocator: ServiceLocator) {
    route("/api/role") {

        get("/") {
            call.response.cacheControl(
                CacheControl.MaxAge(
                    60 * 60 * 24 * 30,
                    visibility = CacheControl.Visibility.Public
                )
            )
            call.respond(serviceLocator.roleService.getAll())
        }

        get("/{role}/skill-info") {
            call.response.cacheControl(CacheControl.MaxAge(60 * 60 * 24, visibility = CacheControl.Visibility.Public))
            val role: String = call.getStringParameter("role")
            call.respond(serviceLocator.skillInfoService.getByRole(role))

        }
    }
}