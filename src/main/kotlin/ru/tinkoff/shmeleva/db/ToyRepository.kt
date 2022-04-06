package ru.tinkoff.shmeleva.db

import org.springframework.stereotype.Repository

@Repository
interface ToyRepository {

    fun addToy(toy: ToyDB)

    fun getToys(): List<ToyDB>

    fun getToy(id: Int): ToyDB
}