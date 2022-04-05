package ru.tinkoff.shmeleva.toyStore

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.db.ToyRepository

@Service
class ToyService( private val toyRepository: ToyRepository
) {

    fun addToy(requestToy: RequestToy) {
        toyRepository.addToy(RequestToy(requestToy.toyname, requestToy.toytype, requestToy.price))
    }

    fun getToys() = toyRepository.getToys()

}