package com.kaiserpudding.api.userdata.skill

import com.kaiserpudding.extension.request
import com.kaiserpudding.model.NewSkill
import com.kaiserpudding.model.Skill
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.skill(service: SkillService) {
    route("api/skill") {

        get("/{id}") {
            request {
                val id = checkNotNull(call.parameters["id"]).toInt()
                call.respond(checkNotNull(service.get(id)))
            }
        }

        post("/") {
            request {
                val skill: NewSkill = call.receive()
                call.respond(HttpStatusCode.OK, checkNotNull(service.create(skill)))
            }
        }

        put("/") {
            request{
                val skill: Skill = call.receive()
                service.update(skill)
                call.respond(HttpStatusCode.OK)
            }
        }

        delete("/{id}") {
            request{
                val id = checkNotNull(call.parameters["id"]).toInt()
                check(service.delete(id))
                call.respond(HttpStatusCode.OK)
            }
        }


    }
}

