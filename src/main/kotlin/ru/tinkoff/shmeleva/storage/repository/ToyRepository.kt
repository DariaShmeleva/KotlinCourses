package ru.tinkoff.shmeleva.storage.repository

import ru.tinkoff.shmeleva.storage.entity.ToyEntity

interface ToyRepository {

    fun addToy(toy: ToyEntity)

    fun getToys(): List<ToyEntity>

    fun getToy(id: Int): ToyEntity
}