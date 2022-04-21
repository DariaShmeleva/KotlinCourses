package ru.tinkoff.shmeleva.client

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono
import ru.tinkoff.shmeleva.dto.ToyRequest

@Component
class ToyClient(private var client: WebClient) {

    suspend fun toyProcessed(toy: ToyRequest) : ToyRequest {
        return client.post()
            .uri("/toy")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(toy), ToyRequest::class.java)
            .retrieve()
            .awaitBody()
    }
}
