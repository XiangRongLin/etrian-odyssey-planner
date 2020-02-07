package com.kaiserpudding.api.userdata.party

import com.kaiserpudding.extension.request
import com.kaiserpudding.model.NewParty
import com.kaiserpudding.model.Party
import com.kaiserpudding.model.PartyMember
import com.kaiserpudding.model.Position
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.party(service: PartyService) {
    route("api/party") {

        get("/") {
            request {
                call.respond(service.getAll())
            }
        }

        get("/{id}") {
            request {
                val id = checkNotNull(call.parameters["id"]).toInt()
                call.respond(checkNotNull(service.get(id)))

            }
        }

        post("/") {
            request {
                val party: NewParty = call.receive()
                call.respond(HttpStatusCode.Created, service.create(party))
            }
        }

        put("/") {
            request {
                val party: Party = call.receive()
                service.update(party)
                call.respond(HttpStatusCode.OK)
            }
        }

        delete("/{id}") {
            request {
                val id = checkNotNull(call.parameters["id"]).toInt()
                check(service.delete(id))
                call.respond(HttpStatusCode.OK)
            }
        }

        get("/{id}/member") {
            request {
                val id = checkNotNull(call.parameters["id"]).toInt()
                call.respond(service.getPartyMembers(id))
            }
        }

        put("/{party_id}/member/{member_id}") {
            request {
                val partyId = checkNotNull(call.parameters["party_id"]).toInt()
                val memberId = checkNotNull(call.parameters["member_id"]).toInt()
                val position: Position = call.receive()
                service.upsertMember(PartyMember(partyId, memberId, position))
                call.respond(HttpStatusCode.OK)
            }
        }

        delete("/{party_id}/member/{member_id}") {
            request {
                val partyId = checkNotNull(call.parameters["party_id"]).toInt()
                val memberId = checkNotNull(call.parameters["member_id"]).toInt()
                check(service.removeMember(partyId, memberId))
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}