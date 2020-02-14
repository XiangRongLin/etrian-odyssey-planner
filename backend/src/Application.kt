package com.kaiserpudding

import com.fasterxml.jackson.databind.SerializationFeature
import com.kaiserpudding.api.gamedata.role.RoleService
import com.kaiserpudding.api.gamedata.role.role
import com.kaiserpudding.api.gamedata.skillinfo.SkillInfoService
import com.kaiserpudding.api.gamedata.skillinfo.skillInfo
import com.kaiserpudding.api.userdata.character.CharacterService
import com.kaiserpudding.api.userdata.character.character
import com.kaiserpudding.api.userdata.party.PartyService
import com.kaiserpudding.api.userdata.party.party
import com.kaiserpudding.api.userdata.skill.SkillService
import com.kaiserpudding.api.userdata.skill.skill
import com.kaiserpudding.database.DatabaseFactory
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import freemarker.cache.*
import io.ktor.freemarker.*
import io.ktor.http.content.*
import io.ktor.sessions.*
import io.ktor.features.*
import io.ktor.auth.*
import io.ktor.jackson.jackson
import kotlinx.coroutines.launch

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    install(CORS) {
        method(HttpMethod.Options)
//        header(HttpHeaders.AccessControlAllowHeaders)
//        header(HttpHeaders.ContentType)
        header(HttpHeaders.AccessControlAllowOrigin)
        host("localhost:8081")
    }

    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    install(Authentication) {
    }

    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
    }

    install(Routing) {
        character(CharacterService())
        role(RoleService())
        skillInfo(SkillInfoService())
        skill(SkillService())
        party(PartyService())
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/html-freemarker") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("data" to IndexData(listOf(1, 2, 3, 4, 5, 6))), ""))
        }

        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }

        get("/session/increment") {
            val session = call.sessions.get<MySession>() ?: MySession()
            call.sessions.set(session.copy(count = session.count + 1))
            call.respondText("Counter is ${session.count}. Refresh to increment.")
        }


        install(StatusPages) {
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationException> { cause ->
                call.respond(HttpStatusCode.Forbidden)
            }

        }
    }
    launch {
        DatabaseFactory.init()
        }
}

data class IndexData(val items: List<Int>)

data class MySession(val count: Int = 0)

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
