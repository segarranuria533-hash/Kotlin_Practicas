package Tema1

import kotlin.concurrent.thread

fun main() {
    val comandos = listOf("5", "10", "15")
    val hilos = comandos.map { segundos ->
        thread {
            val process = ProcessBuilder("bash","-c","sleep", segundos).start()
            process.waitFor()
            println("Proceso sleep $segundos terminado")
        }
    }
    hilos.forEach { it.join() }
}