package ru.tinkoff.shmeleva.repository

import org.springframework.stereotype.Repository
import ru.tinkoff.shmeleva.db.ToyDB

@Repository
interface ToyRepository {

    fun addToy(toy: ToyDB)

    fun getToys(): List<ToyDB>

    fun getToy(id: Int): ToyDB
}