package com.kaiserpudding.api.userdata.skill

//
//fun Route.skill(service: SkillService) {
//    route("api/skill") {
//
//        get("/") {
//            val character = call.getIntParameter("character")
//            call.respond(service.getFromCharacter(character))
//        }
//
//        post("/") {
//            val skill: NewSkill = call.receive()
//            call.respond(HttpStatusCode.OK, service.create(skill))
//        }
//
//        put("/{id}") {
//            val id = call.getIntParameter("id")
//            val skill: NewSkill = call.receive()
//            service.update(Skill(id, skill))
//            call.respond(HttpStatusCode.OK)
//        }
//
//        delete("/{id}") {
//            val id = call.getIntParameter("id")
//            service.delete(id)
//            call.respond(HttpStatusCode.OK)
//        }
//    }
//}
//
