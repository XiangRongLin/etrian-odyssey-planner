package com.kaiserpudding.api.userdata.character

import com.kaiserpudding.api.userdata.skill.NewSkill
import com.kaiserpudding.api.userdata.skill.SkillService
import com.kaiserpudding.extension.getIntParameter
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

fun Route.character(characterService: CharacterService, skillService: SkillService) {
    route("api/character") {

        get("/") {
            val parameters = call.request.queryParameters
            val name = parameters["name"]
            if (name.isNullOrEmpty()) {
                call.respond(characterService.getAll())
            } else {
                call.respond(characterService.searchBy(name))
            }
        }

        get("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val character = characterService.get(id)
            if (character != null) {
                call.respond(character)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }

        post("/") {
            val character: NewCharacter = call.receive()
            call.respond(HttpStatusCode.OK, characterService.create(character))
        }

        put("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val character: NewCharacter = call.receive()
            characterService.update(Character(id, character))
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            characterService.delete(id)
            call.respond(HttpStatusCode.NoContent)
        }

        route("{id}/skill") {

            get("/") {
                val id = call.getIntParameter("id")
                call.respond(skillService.getFromCharacter(id))
            }

            put("/") {
                val id = call.getIntParameter("id")
                val skills: List<NewSkill> = call.receive()
                skillService.updateSkills(id, skills)
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}


