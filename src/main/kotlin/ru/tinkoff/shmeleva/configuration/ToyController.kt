package ru.tinkoff.shmeleva.configuration

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.shmeleva.toyStore.Toy
import ru.tinkoff.shmeleva.toyStore.ToyService

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