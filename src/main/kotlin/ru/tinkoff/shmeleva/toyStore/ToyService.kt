package ru.tinkoff.shmeleva.toyStore

import org.springframework.stereotype.Service

@Service
class ToyService(
    private val toyClient: ToyClient,
    private val toyRepository: ToyRepository
) {

    fun addToy(requestToy: RequestToy): ResponseToy {
        val responseToy = toyClient.enrichToyInfo(requestToy)
        toyRepository.addToy(responseToy)
        return responseToy
    }

    fun getToy(id: Long) =
        toyRepository.getToy(id)

    fun getAllLowerPrice(price: Int) =
        toyRepository.getAllLowerPrice(price)
}