package com.kaiserpudding

import com.auth0.jwk.JwkProvider
import com.auth0.jwk.JwkProviderBuilder
import com.fasterxml.jackson.databind.SerializationFeature
import com.kaiserpudding.api.gamedata.role
import com.kaiserpudding.api.gamedata.skillInfo
import com.kaiserpudding.api.userdata.character
import com.kaiserpudding.api.userdata.party
import com.kaiserpudding.api.userdata.user
import com.kaiserpudding.database.DatabaseFactory
import com.kaiserpudding.database.DatabaseMigrations
import com.kaiserpudding.service.ServiceLocator
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.*
import io.ktor.auth.jwt.JWTCredential
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
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
import io.ktor.sessions.*
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
        basic(name = "basicAuth") {
            validate { credentials ->
                if (credentials.name == credentials.password) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
        val jwtIssuer = environment.config.property("jwt.domain").getString()
        val jwtAudience = environment.config.property("jwt.audience").getString()
        val jwtRealm = environment.config.property("jwt.realm").getString()
        val jwkProvider = JwkProviderBuilder(jwtIssuer).build()
        jwt(name = "jwt") {
            realm = jwtRealm
            verifier(jwkProvider, jwtIssuer)
            validate { credential ->
                JWTPrincipal(credential.payload)
//                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
            }
        }
    }



    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
    }

    val serviceLocator = if (testing) {
        ServiceLocator.getDemoServiceLocator()
    } else {
        ServiceLocator.getImplServiceLocator()
    }
    install(Routing) {
        role(serviceLocator)
        skillInfo(serviceLocator)
        character(serviceLocator)
        party(serviceLocator)
        user(serviceLocator)
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
            exception<UserAccessException> { cause ->
                call.respond(HttpStatusCode.Forbidden, cause)
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

//private fun makeJwtVerifier(issuer: String, audience: String): JWTVerifier {
//    val publicKey =
//    val algorithm = Algorithm.RSA256()
//
//    val build = JWT
//        .require(algorithm)
//        .withAudience(audience)
//        .withIssuer(issuer)
//        .build()
//    return build
//}
fun AuthenticationPipeline.jwtAuthentication(
    jwkProvider: JwkProvider,
    issuer: String,
    realm: String,
    validate: (JWTCredential) -> Principal?
) {

}

