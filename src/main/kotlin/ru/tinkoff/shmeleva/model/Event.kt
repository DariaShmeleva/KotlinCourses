package ru.tinkoff.shmeleva.model

import ru.tinkoff.shmeleva.util.EventStatus
import ru.tinkoff.shmeleva.util.EventType
import java.io.Serializable

data class Event(
    val id: Long,
    val type: EventType,
    val body: String,
    var status: EventStatus
) : Serializable