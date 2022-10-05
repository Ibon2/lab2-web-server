package es.unizar.webeng.lab2

import java.time.LocalDateTime
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


class TimeDTO(val time: LocalDateTime)

interface TimeProvider {
  fun now(): LocalDateTime
}

@Service
class TimeService : TimeProvider {
  override fun now() = LocalDateTime.now()
}

fun LocalDateTime.toDTO() = TimeDTO(time = this)

@RestController
class TimeController(val service: TimeProvider) {
  @GetMapping("/time") fun time() = service.now().toDTO()
}
