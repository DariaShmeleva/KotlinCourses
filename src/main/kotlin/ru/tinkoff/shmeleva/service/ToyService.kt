package ru.tinkoff.shmeleva.service

import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.model.ToyRequest
import ru.tinkoff.shmeleva.model.ToyResponse
import ru.tinkoff.shmeleva.client.ToyClient
import ru.tinkoff.shmeleva.repository.ToyRepository

@Service
class ToyService(
    private val toyClient: ToyClient,
    private val toyRepository: ToyRepository
) {

    fun addToy(toyRequest: ToyRequest): ToyResponse {
        val responseToy = toyClient.enrichToyInfo(toyRequest)
        toyRepository.addToy(responseToy)
        return responseToy
    }

    fun getToy(id: Long) =
        toyRepository.getToy(id)

    fun getAllLowerPrice(price: Int) =
        toyRepository.getAllLowerPrice(price)
}