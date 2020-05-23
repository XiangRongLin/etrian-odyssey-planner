package com.kaiserpudding.api.userdata.character

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

fun Route.character(characterService: CharacterService) {
    route("api/character") {

        get("/") {
            val parameters = call.request.queryParameters
            val name = parameters["name"]
            if(name.isNullOrEmpty()) {
                call.respond(characterService.getAll())
            } else {
                call.respond(characterService.searchBy(name))
            }
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Missing id")
            val character = characterService.get(id)
            if (character != null) {
                call.respond(character)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }

        //https://stackoverflow.com/questions/630453/put-vs-post-in-rest
        //create
        post("/") {
            val character: NewCharacter = call.receive()
            call.respond(HttpStatusCode.OK, characterService.create(character))
        }

        //update
        put("/") {
            val character = call.receive<Character>()
            characterService.update(character)
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Missing id")
            characterService.delete(id)
            call.respond(HttpStatusCode.NoContent)
        }
    }
}