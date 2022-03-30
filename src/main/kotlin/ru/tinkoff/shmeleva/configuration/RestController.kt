package ru.tinkoff.shmeleva.configuration

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.shmeleva.toyStore.RequestToy
import ru.tinkoff.shmeleva.toyStore.ToyService

@RestController
@RequestMapping("/toys")
class RestController(
    private val toyService: ToyService
) {

    @PostMapping("/add")
    fun addToy(
        @RequestBody requestToy: RequestToy
    ) = toyService.addToy(requestToy)

    @GetMapping("/get/{id}")
    fun getToy(
        @PathVariable id: Long
    ) = toyService.getToy(id)

    @GetMapping("/getAllLowerPrice")
    fun getAllLowerPrice(
        @RequestParam price: Int
    ) = toyService.getAllLowerPrice(price)
}