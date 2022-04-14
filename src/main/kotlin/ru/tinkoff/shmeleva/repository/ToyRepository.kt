package ru.tinkoff.shmeleva.repository

import ru.tinkoff.shmeleva.entity.entity.ToyEntity

interface ToyRepository {

    fun addToy(toy: ToyEntity)

    fun getToys(): List<ToyEntity>

    fun getToy(id: Int): ToyEntity
}