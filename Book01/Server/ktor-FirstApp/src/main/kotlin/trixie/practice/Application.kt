package trixie.practice

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import trixie.practice.plugins.*

fun main() {
    // ifconfig> en0> ip Address:192.168.68.71
    embeddedServer(Netty, port = 8080, host = "192.168.68.71") {
        configureRouting()
    }.start(wait = true)
}
