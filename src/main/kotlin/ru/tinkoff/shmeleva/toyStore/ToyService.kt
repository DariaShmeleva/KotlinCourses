package ru.tinkoff.shmeleva.toyStore

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.db.ToyRepository

@Service
class ToyService(
    private val toyRepository: ToyRepository
) {

    fun addToy(toy: Toy) {
        toyRepository.addToy(toy.toDB())
    }

    fun getToys() = toyRepository.getToys().map { it.toDto() }

    fun getToy(id: Int) = toyRepository.getToy(id).toDto()

}