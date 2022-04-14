package ru.tinkoff.shmeleva.toyStore

import ru.tinkoff.shmeleva.entity.entity.ToyEntity
import ru.tinkoff.shmeleva.model.Toy

fun ToyEntity.toDto(): Toy =
    Toy(
        this.name,
        this.type,
        this.price
    )

fun Toy.toDB(): ToyEntity =
    ToyEntity(
        name = this.name,
        type = this.type,
        price = this.price,
    )
