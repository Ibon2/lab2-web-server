package es.unizar.webeng.lab2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application
fun main(vararg args: String) {
    runApplication<Application>(*args)
}
