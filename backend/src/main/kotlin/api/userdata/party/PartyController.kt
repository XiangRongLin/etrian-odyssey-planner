package com.kaiserpudding.api.userdata.party

import com.kaiserpudding.repository.PartyRepository
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

fun Route.party(service: PartyRepository) {
    route("api/party") {

        get("/") {
            call.respond(service.getAll())
        }

        get("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            call.respond(checkNotNull(service.get(id)))
        }

        post("/") {
            val party: NewParty = call.receive()
            call.respond(HttpStatusCode.Created, service.create(party))
        }

        put("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            val party: NewParty = call.receive()
            service.update(Party(id, party))
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            check(service.delete(id))
            call.respond(HttpStatusCode.OK)
        }

        route("{id}/member") {
            put("/") {
                val partyId = checkNotNull(call.parameters["id"]).toInt()
                val members = call.receive<List<PartyMember>>()
                service.updateMembers(partyId, members)
                call.respond(HttpStatusCode.OK)
            }

            delete("/{member_id}") {
                val partyId = checkNotNull(call.parameters["id"]).toInt()
                val memberId = checkNotNull(call.parameters["member_id"]).toInt()
                check(service.removeMember(partyId, memberId))
                call.respond(HttpStatusCode.OK)
            }
        }

    }
}