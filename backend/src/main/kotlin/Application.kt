package com.kaiserpudding

import com.fasterxml.jackson.databind.SerializationFeature
import com.kaiserpudding.api.gamedata.role.role
import com.kaiserpudding.api.gamedata.skillinfo.skillInfo
import com.kaiserpudding.api.userdata.character.character
import com.kaiserpudding.api.userdata.party.party
import com.kaiserpudding.database.DatabaseFactory
import com.kaiserpudding.database.DatabaseMigrations
import com.kaiserpudding.repository.CharacterRepository
import com.kaiserpudding.repository.PartyRepository
import com.kaiserpudding.repository.RoleRepository
import com.kaiserpudding.repository.SkillInfoRepository
import com.kaiserpudding.repository.SkillRepository
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import io.ktor.sessions.get
import io.ktor.sessions.sessions
import io.ktor.sessions.set
import kotlin.collections.set

fun main(args: Array<String>) {
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
        role(RoleRepository())
        skillInfo(SkillInfoRepository())
        character(CharacterRepository(), SkillRepository())
        party(PartyRepository())
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
            exception<NumberFormatException> { cause ->
                call.respond(HttpStatusCode.BadRequest)
            }
            exception<IllegalStateException> { cause ->
                call.respond(HttpStatusCode.BadRequest)
            }
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
            exception<AuthorizationException> { cause ->
                call.respond(HttpStatusCode.Forbidden)
            }

        }
    }
    DatabaseMigrations.migrate()
    DatabaseFactory.init()
}

data class IndexData(val items: List<Int>)

data class MySession(val count: Int = 0)

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()

