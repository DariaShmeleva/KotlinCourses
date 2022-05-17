package ru.tinkoff.shmeleva.storage.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import ru.tinkoff.shmeleva.storage.entity.EventEntity
import ru.tinkoff.shmeleva.util.EventStatus

interface EventRepository : JpaRepository<EventEntity, Long> {
    fun findByStatus(status: EventStatus): List<EventEntity>

    @Query("update EventEntity e set e.status = ?1 where e.id = ?2")
    @Modifying
    fun updateStatus(status: EventStatus, id: Long)
}