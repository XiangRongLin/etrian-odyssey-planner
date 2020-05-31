package com.kaiserpudding.api.userdata

import com.kaiserpudding.extension.getIntParameter
import com.kaiserpudding.model.CharacterSummary
import com.kaiserpudding.model.NewCharacter
import com.kaiserpudding.model.Skill
import com.kaiserpudding.queryOptions.CharacterQueryOptions
import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.character(serviceLocator: ServiceLocator) {
    route("api/character") {

        get("/") {
            val parameters = call.request.queryParameters
            val name = parameters["name"]
            if (name.isNullOrEmpty()) {
                call.respond(serviceLocator.characterService.getAll())
            } else {
                call.respond(serviceLocator.characterService.getBy(CharacterQueryOptions(name = name)))
            }
        }

        authenticate("jwt") {

            get("/{id}") {
                val id = checkNotNull(call.parameters["id"]).toInt()
                val character = serviceLocator.characterService.get(id)
                if (character != null) {
                    call.respond(character)
                } else {
                    call.respond(HttpStatusCode.NotFound)
                }
            }
        }
        authenticate("basicAuth") {
            post("/") {
                val character: NewCharacter = call.receive()
                call.respond(HttpStatusCode.OK, serviceLocator.characterService.create(character, 1))//TODO
            }
        }


        put("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val character: NewCharacter = call.receive()
            serviceLocator.characterService.update(CharacterSummary(id, character), 1)//TODO
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            serviceLocator.characterService.delete(id, 1)//TODO
            call.respond(HttpStatusCode.NoContent)
        }

        route("{id}/skill") {

            get("/") {
                val id = call.getIntParameter("id")
                call.respond(serviceLocator.skillService.getByCharacter(id))
            }

            patch("/") {
                val id = call.getIntParameter("id")
                val skills: List<Skill> = call.receive()
                serviceLocator.skillService.update(id, skills, 1)//TODO
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}


