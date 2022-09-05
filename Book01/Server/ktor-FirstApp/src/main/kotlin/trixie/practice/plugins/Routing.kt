package trixie.practice.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    //Starting point for a Ktor app:
    install(ContentNegotiation) {

    }

    routing {
        get("/") {
            call.respondText("Hello World!")
            var test = mapOf("message" to "hello")
            call.respond(test)
        }
        //取得所有題目
        get("api/puzzles") {
            TODO()
        }
        //新增題目
        post("api/puzzles") {
            TODO()
        }
        //取得單個題目
        get("api/puzzles/{id}") {
            TODO()
        }
        //刪除單個題目
        delete("api/puzzles/{id}") {
            TODO()
        }
    }
}
