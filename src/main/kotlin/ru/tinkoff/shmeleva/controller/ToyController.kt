package ru.tinkoff.shmeleva.controller

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.shmeleva.dto.ToyRequest
import ru.tinkoff.shmeleva.dto.ToyResponse
import ru.tinkoff.shmeleva.service.ToyService

@RestController
class ToyController(
    private val toyService: ToyService
) {

    @PostMapping("/best-toy")
    fun addToy(toy: ToyRequest) = toyService.addToy(toy)

    @GetMapping("/best-toy/{id}")
    fun getToy(
        @PathVariable id: Int
    ): ToyResponse =
        toyService.getToy(id)
}