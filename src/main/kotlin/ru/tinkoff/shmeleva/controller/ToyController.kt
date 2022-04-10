package ru.tinkoff.shmeleva.controller

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.shmeleva.model.Toy
import ru.tinkoff.shmeleva.service.ToyService

@RestController
@RequestMapping("/toys")
class ToyController(
    private val toyService: ToyService
) {

    @PostMapping("/add")
    fun addToy(
        @RequestBody toy: Toy
    ) = toyService.addToy(toy)

    @GetMapping("/getAll")
    fun getToys(): List<Toy> {
        return toyService.getToys()
    }

    @GetMapping("/get/{id}")
    fun getToy(
        @PathVariable id: Int
    ): Toy =
        toyService.getToy(id)
}