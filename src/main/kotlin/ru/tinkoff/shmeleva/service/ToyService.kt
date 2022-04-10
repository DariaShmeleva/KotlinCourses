package ru.tinkoff.shmeleva.service

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.repository.ToyRepository
import ru.tinkoff.shmeleva.model.Toy
import ru.tinkoff.shmeleva.toyStore.toDB
import ru.tinkoff.shmeleva.toyStore.toDto

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