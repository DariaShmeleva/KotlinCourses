package ru.tinkoff.shmeleva.toyStore

import ru.tinkoff.shmeleva.model.Event
import ru.tinkoff.shmeleva.storage.entity.EventEntity

fun EventEntity.toDto() =
    Event(
        this.id!!,
        this.type,
        this.body,
        this.status
    )
