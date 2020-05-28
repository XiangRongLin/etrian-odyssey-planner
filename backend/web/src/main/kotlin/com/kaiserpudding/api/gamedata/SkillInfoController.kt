package com.kaiserpudding.api.gamedata

import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.http.CacheControl
import io.ktor.response.cacheControl
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.skillInfo(serviceLocator: ServiceLocator) {
    route("api/skill-info") {

        get("/") {
            call.response.cacheControl(CacheControl.MaxAge(60 * 60 * 24, visibility = CacheControl.Visibility.Public))
            call.respond(serviceLocator.skillInfoService.getAll())
        }
    }
}