package ru.tinkoff.shmeleva

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class TinkoffL1

fun main() {
    runApplication<TinkoffL1>()
}
