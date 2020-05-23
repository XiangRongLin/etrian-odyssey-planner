package com.kaiserpudding.api.userdata.skill

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put
import io.ktor.routing.route

fun Route.skill(service: SkillService) {
    route("api/skill") {

        get("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            call.respond(checkNotNull(service.get(id)))
        }

        post("/") {
            val skill: NewSkill = call.receive()
            call.respond(HttpStatusCode.OK, checkNotNull(service.create(skill)))
        }

        put("/") {
            val skill: Skill = call.receive()
            service.update(skill)
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            check(service.delete(id))
            call.respond(HttpStatusCode.OK)
        }


    }
}

