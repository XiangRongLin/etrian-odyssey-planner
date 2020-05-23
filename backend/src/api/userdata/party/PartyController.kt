package com.kaiserpudding.api.userdata.party

import com.kaiserpudding.api.model.PartyMember
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

fun Route.party(service: PartyService) {
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

        put("/") {
            val party: Party = call.receive()
            service.update(party)
            call.respond(HttpStatusCode.OK)
        }

        delete("/{id}") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            check(service.delete(id))
            call.respond(HttpStatusCode.OK)
        }

        get("/{id}/member") {
            val id = checkNotNull(call.parameters["id"]).toInt()
            call.respond(service.getPartyMembers(id))
        }

        put("/{party_id}/member/{member_id}") {
            val partyId = checkNotNull(call.parameters["party_id"]).toInt()
            val memberId = checkNotNull(call.parameters["member_id"]).toInt()
            val position: Position = call.receive()
            service.upsertMember(
                PartyMember(
                    partyId,
                    memberId,
                    position
                )
            )
            call.respond(HttpStatusCode.OK)
        }

        delete("/{party_id}/member/{member_id}") {
            val partyId = checkNotNull(call.parameters["party_id"]).toInt()
            val memberId = checkNotNull(call.parameters["member_id"]).toInt()
            check(service.removeMember(partyId, memberId))
            call.respond(HttpStatusCode.OK)
        }
    }
}