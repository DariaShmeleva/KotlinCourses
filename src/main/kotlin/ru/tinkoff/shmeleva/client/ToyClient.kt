package ru.tinkoff.shmeleva.client

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.tinkoff.shmeleva.model.ToyRequest
import ru.tinkoff.shmeleva.model.ToyResponse

@Service
class ToyClient(
    private val restTemplate: RestTemplate
) {
    @Value("\${toy.address}")
    private lateinit var toyAddress: String

    fun enrichToyInfo(toyRequest: ToyRequest) =
        restTemplate.postForEntity(toyAddress, toyRequest, ToyResponse::class.java).body
            ?: throw IllegalStateException("Не удалось обогатить данные")
}