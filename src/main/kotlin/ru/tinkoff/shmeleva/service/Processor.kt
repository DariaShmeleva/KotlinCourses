package ru.tinkoff.shmeleva.service

import ru.tinkoff.shmeleva.model.Event

interface Processor {
    fun processEvent(event: Event)
}