package ru.tinkoff.shmeleva.repository

import org.springframework.stereotype.Repository
import ru.tinkoff.shmeleva.exception.advice.MyToyException
import ru.tinkoff.shmeleva.model.ToyResponse

@Repository
class ToyRepository {

    private val toys = mutableMapOf<Long, ToyResponse>()
    private var id = -1L

    fun addToy(responseToy: ToyResponse) {
        toys[++id] = responseToy
    }

    fun getToy(id: Long) =
        toys[id] ?: throw IllegalArgumentException("Отсутствует игрушка с таким штрихкодом")

    fun getAllLowerPrice(price: Int) = toys
        .filter { it.value.price < price }.values
        .ifEmpty { throw MyToyException("Повторите позже") }

}