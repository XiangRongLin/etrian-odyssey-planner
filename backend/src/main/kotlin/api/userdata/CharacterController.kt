package com.kaiserpudding.api.userdata

import com.kaiserpudding.extension.getIntParameter
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.NewSkill
import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.patch
import io.ktor.routing.post
import io.ktor.routing.put
import io.ktor.routing.route

fun Route.character(serviceLocator: ServiceLocator) {
    route("api/character") {

        get("/") {
            val parameters = call.request.queryParameters
            val name = parameters["name"]
            if (name.isNullOrEmpty()) {
                call.respond(serviceLocator.characterService.getAll())
            } else {
                call.respond(serviceLocator.characterService.getByName(name))
            }
        }

        get("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val character = serviceLocator.characterService.get(id)
            if (character != null) {
                call.respond(character)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }

        post("/") {
            val character: NewCharacter = call.receive()
            call.respond(HttpStatusCode.OK, serviceLocator.characterService.create(character))
        }

        put("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val character: NewCharacter = call.receive()
            serviceLocator.characterService.update(CharacterSummary(id, character))
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            serviceLocator.characterService.delete(id)
            call.respond(HttpStatusCode.NoContent)
        }

        route("{id}/skill") {

            get("/") {
                val id = call.getIntParameter("id")
                call.respond(serviceLocator.characterService.getSkillsByCharacter(id))
            }

            patch("/") {
                val id = call.getIntParameter("id")
                val skills: List<NewSkill> = call.receive()
                serviceLocator.characterService.updateSkills(id, skills)
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}


