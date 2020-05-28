package com.kaiserpudding.api.userdata

import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.NewPartyMember
import com.kaiserpudding.model.Party
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

fun Route.party(serviceLocator: ServiceLocator) {
    route("api/party") {

        get("/") {
            call.respond(serviceLocator.partyService.getAll())
        }

        get("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            call.respond(checkNotNull(serviceLocator.partyService.get(id)))
        }

        post("/") {
            val party: NewParty = call.receive()
            call.respond(HttpStatusCode.Created, serviceLocator.partyService.create(party, 1))//TODO
        }

        put("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val party: NewParty = call.receive()
            serviceLocator.partyService.update(Party(id, party), 1)//TODO
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            check(serviceLocator.partyService.delete(id, 1))//TODO
            call.respond(HttpStatusCode.OK)
        }

        route("{id}/member") {
            patch("/") {
                val partyId = checkNotNull(call.parameters["id"]).toInt()
                val members = call.receive<List<NewPartyMember>>()
                serviceLocator.partyService.updateMembers(partyId, members, 1)//TODO
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}