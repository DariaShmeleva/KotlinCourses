package ru.tinkoff.shmeleva.component

import org.apache.activemq.command.ActiveMQQueue
import org.springframework.jms.core.JmsTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.tinkoff.shmeleva.service.EventService
import ru.tinkoff.shmeleva.util.EventStatus

@Component
class Producer(
    private val eventService: EventService,
    private val queue: ActiveMQQueue,
    private val jmsTemplate: JmsTemplate
) {

    @Scheduled(cron = "0 0 */1 * * *")
    fun produceEvents() {
        val newEvents = eventService.getNewEvents()
        newEvents.map {
            val event = it
            eventService.updateStatus(event, EventStatus.IN_PROCESS)
            runCatching { jmsTemplate.convertAndSend(queue, event) }.onFailure {
                eventService.updateStatus(
                    event,
                    EventStatus.ERROR
                )
            }
        }
    }
}