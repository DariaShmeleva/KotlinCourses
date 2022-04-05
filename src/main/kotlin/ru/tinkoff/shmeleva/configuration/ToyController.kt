package ru.tinkoff.shmeleva.configuration

import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.shmeleva.toyStore.RequestToy
import ru.tinkoff.shmeleva.toyStore.ResponseToy
import ru.tinkoff.shmeleva.toyStore.ToyService

@RestController
@RequestMapping("/toys")
class ToyController(
    private val toyService: ToyService
) {

    @PostMapping("/add")
    fun addToy(@RequestBody requestToy: RequestToy
    ) = toyService.addToy(requestToy)

    @GetMapping("/get/{id}")
    fun getToys(): List<ResponseToy> {
        return toyService.getToys().map{ ResponseToy(it.toyId!!, it.toyname!!, it.toytype!!, it.price!!)}
    }
}