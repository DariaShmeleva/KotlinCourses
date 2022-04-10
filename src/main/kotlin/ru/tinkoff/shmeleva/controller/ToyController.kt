package ru.tinkoff.shmeleva.controller

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.shmeleva.model.ToyRequest
import ru.tinkoff.shmeleva.service.ToyService

@RestController
@RequestMapping("/toys")
class ToyController(
    private val toyService: ToyService
) {

    @PostMapping("/add")
    fun addToy(
        @RequestBody toyRequest: ToyRequest
    ) = toyService.addToy(toyRequest)

    @GetMapping("/get/{id}")
    fun getToy(
        @PathVariable id: Long
    ) = toyService.getToy(id)

    @GetMapping("/getAllLowerPrice")
    fun getAllLowerPrice(
        @RequestParam price: Int
    ) = toyService.getAllLowerPrice(price)
}