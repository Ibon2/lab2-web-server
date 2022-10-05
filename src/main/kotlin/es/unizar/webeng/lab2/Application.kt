package es.unizar.webeng.lab2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
class Application

fun main(vararg args: String) {
    runApplication<Application>(*args)
}

@RestController
class MessageResource {
    var PATH: String = "/error"
    @GetMapping("/time")
    fun time(): String = 
        LocalDateTime.now().toLocalTime().toString()

    @RequestMapping
    fun error():String = "Lo siento, nuestros ingenieros están solucionando los errores.\n Vuelve más tarde, Gracias :)"

    @Override
    fun getErrorPath():String = PATH

}