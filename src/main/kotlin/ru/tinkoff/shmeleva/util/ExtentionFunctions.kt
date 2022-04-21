package ru.tinkoff.shmeleva.util

import ru.tinkoff.shmeleva.dto.ToyRequest
import ru.tinkoff.shmeleva.dto.ToyResponse
import ru.tinkoff.shmeleva.storage.entity.ToyEntity

fun ToyRequest.toModel(): ToyEntity {
    return ToyEntity(
        name = name,
        type = type,
        price = price
    )
}

fun ToyEntity.toDto(): ToyResponse {
    return ToyResponse(
        name = name,
        type = type,
        price = price
    )
}