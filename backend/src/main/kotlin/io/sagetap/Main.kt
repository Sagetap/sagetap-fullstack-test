package io.sagetap

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.statuspages.StatusPages
import io.sagetap.db.CatsStorage
import io.sagetap.db.DatabaseConfig
import io.sagetap.db.toResponse
import io.ktor.server.plugins.cors.routing.*

fun main() {
    embeddedServer(Netty, port = 9005) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    DatabaseConfig.init()
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            cause.printStackTrace()
            call.respondText("Internal server error: ${cause.localizedMessage}", status = io.ktor.http.HttpStatusCode.InternalServerError)
        }
    }

    install(ContentNegotiation) {
        json(Json { prettyPrint = true })
    }
    install(CORS) {
        anyHost()
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Post)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.ContentType)
    }

    val storage = CatsStorage(DatabaseConfig.database)
    routing {
        get("/cats") {
            call.respond(storage.getAll().map { it.toResponse()})
        }
    }
}