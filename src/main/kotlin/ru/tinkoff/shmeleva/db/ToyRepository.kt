package ru.tinkoff.shmeleva.db

import org.springframework.stereotype.Repository
import ru.tinkoff.shmeleva.toyStore.RequestToy

@Repository
interface ToyRepository {

    fun addToy(requestToy: RequestToy)

    fun getToys(): List<Toy>

}