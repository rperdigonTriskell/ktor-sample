package com.example

import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRouting()
}

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"Índice de Servicios" }
                    style {
                        +"""
                            body {
                                font-family: Arial, sans-serif;
                                background-color: #f4f4f4;
                                margin: 0;
                                padding: 0;
                            }
                            h1 {
                                text-align: center;
                                color: #333;
                            }
                            .container {
                                display: grid;
                                grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
                                gap: 20px;
                                padding: 20px;
                            }
                            .service {
                                background: #fff;
                                padding: 20px;
                                border-radius: 8px;
                                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                text-align: center;
                            }
                            .service a {
                                text-decoration: none;
                                color: #007BFF;
                                font-size: 18px;
                                display: block;
                                margin-top: 10px;
                            }
                            .service a:hover {
                                text-decoration: underline;
                            }
                        """.trimIndent()
                    }
                }
                body {
                    h1 { +"Índice de Servicios en el Servidor" }
                    div("container") {
                        div("service") {
                            h2 { +"Jenkins" }
                            a(href = "http://tu-servidor:9090/jenkins") { +"Acceder a Jenkins" }
                        }
                        div("service") {
                            h2 { +"Zalenium - Grid Admin" }
                            a(href = "http://tu-servidor:5555/grid/admin/live") { +"Acceder a Zalenium - Grid Admin" }
                        }
                        div("service") {
                            h2 { +"Zalenium - Dashboard" }
                            a(href = "http://tu-servidor:5555/dashboard") { +"Acceder a Zalenium - Dashboard" }
                        }
                    }
                }
            }
        }
    }
}
