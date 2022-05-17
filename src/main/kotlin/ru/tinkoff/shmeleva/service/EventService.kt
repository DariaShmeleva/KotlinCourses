package ru.tinkoff.shmeleva.service

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.util.EventStatus
import org.springframework.transaction.annotation.Transactional
import ru.tinkoff.shmeleva.model.Event
import ru.tinkoff.shmeleva.storage.repository.EventRepository
import ru.tinkoff.shmeleva.toyStore.toDto

@Service
class EventService(
    private val eventRepository: EventRepository
) {
    fun getNewEvents() =
        eventRepository.findByStatus(EventStatus.NEW).map { it.toDto() }

    @Transactional
    fun updateStatus(event: Event, status: EventStatus) {
        eventRepository.updateStatus(status, event.id)
    }
}