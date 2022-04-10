package ru.tinkoff.shmeleva.toyStore

import ru.tinkoff.shmeleva.db.ToyDB
import ru.tinkoff.shmeleva.model.Toy

fun ToyDB.toDto(): Toy =
    Toy(
        this.toyname,
        this.toytype,
        this.price
    )

fun Toy.toDB(): ToyDB =
    ToyDB(
        toyname = this.toyname,
        toytype = this.toytype,
        price = this.price,
    )
