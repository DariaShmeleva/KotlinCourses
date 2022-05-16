package ru.tinkoff.shmeleva.service

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.model.Event

@Service
class PushProcessor: Processor {
    override fun processEvent(event: Event) {
        println("Hello from PUSH service")
    }
}