package ru.tinkoff.shmeleva.toyStore

import org.springframework.stereotype.Repository

@Repository
class ToyRepository {

    private val toys = mutableMapOf<Long, ResponseToy>()
    private var id = -1L

    fun addToy(responseToy: ResponseToy) {
        toys[++id] = responseToy
    }

    fun getToy(id: Long) =
        toys[id] ?: throw IllegalArgumentException("Отсутствует игрушка с таким штрихкодом")

    fun getAllLowerPrice(price: Int) = toys
        .filter { it.value.price < price }.values
        .ifEmpty { throw IllegalArgumentException("Игрушки дешевле отсутствуют") }
}