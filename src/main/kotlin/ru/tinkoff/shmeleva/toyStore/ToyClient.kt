package ru.tinkoff.shmeleva.toyStore

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ToyClient(
    private val restTemplate: RestTemplate
) {
    @Value("\${toy.address}")
    private lateinit var toyAddress: String

    fun enrichToyInfo(requestToy: RequestToy) =
        restTemplate.postForEntity(toyAddress, requestToy, ResponseToy::class.java).body
            ?: throw IllegalStateException("Не удалось обогатить данные")
}