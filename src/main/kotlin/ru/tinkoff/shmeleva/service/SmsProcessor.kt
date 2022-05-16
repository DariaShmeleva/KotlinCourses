package ru.tinkoff.shmeleva.service

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.model.Event

@Service
class SmsProcessor : Processor {
    override fun processEvent(event: Event) {
        println("Hello from SMS service")
    }
}