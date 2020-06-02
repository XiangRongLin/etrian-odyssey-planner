package com.kaiserpudding.api.userdata

import com.kaiserpudding.extension.jwtSubject
import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.PartySummary
import com.kaiserpudding.service.ServiceLocator
import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.party(serviceLocator: ServiceLocator) {
    route("api/party") {

        get("/") {
            call.respond(serviceLocator.partyService.getAll())
        }

        get("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            call.respond(checkNotNull(serviceLocator.partyService.get(id)))
        }

        authenticate("jwt") {
            post("/") {
                val party: NewParty = call.receive()
                call.respond(HttpStatusCode.Created, serviceLocator.partyService.create(party, call.jwtSubject()))
            }

            put("/{id}") {
                val id = checkNotNull(call.parameters["id"]).toInt()
                val party: NewParty = call.receive()
                serviceLocator.partyService.update(PartySummary(id, party), call.jwtSubject())
                call.respond(HttpStatusCode.OK)
            }

            delete("/{id}") {
                val id = checkNotNull(call.parameters["id"]).toInt()
                check(serviceLocator.partyService.delete(id, call.jwtSubject()))
                call.respond(HttpStatusCode.OK)
            }
        }

        route("{id}/member") {
            authenticate {
                patch("/") {
                    val partyId = checkNotNull(call.parameters["id"]).toInt()
                    val members = call.receive<List<NewPartyMember>>()
                    serviceLocator.partyService.updateMembers(partyId, members, call.jwtSubject())
                    call.respond(HttpStatusCode.OK)
                }
            }
        }
    }
}