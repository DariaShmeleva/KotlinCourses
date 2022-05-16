package ru.tinkoff.shmeleva.component

import org.springframework.jms.annotation.JmsListener
import ru.tinkoff.shmeleva.service.EmailProcessor
import org.springframework.stereotype.Component
import ru.tinkoff.shmeleva.model.Event
import ru.tinkoff.shmeleva.service.EventService
import ru.tinkoff.shmeleva.service.PushProcessor
import ru.tinkoff.shmeleva.service.SmsProcessor
import ru.tinkoff.shmeleva.util.EventStatus
import ru.tinkoff.shmeleva.util.EventType

@Component
class Consumer(
    private val emailProcessor: EmailProcessor,
    private val pushProcessor: PushProcessor,
    private val smsProcessor: SmsProcessor,
    private val eventService: EventService
) {

    @JmsListener(destination = "event.queue")
    fun consumeEvents(event: Event) {
        when (event.type) {
            EventType.SMS -> smsProcessor.processEvent(event)
            EventType.EMAIL -> emailProcessor.processEvent(event)
            EventType.PUSH -> pushProcessor.processEvent(event)
        }
        eventService.updateStatus(event, EventStatus.DONE)
    }
}