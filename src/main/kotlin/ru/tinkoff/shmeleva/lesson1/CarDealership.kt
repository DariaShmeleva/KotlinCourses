package ru.tinkoff.shmeleva.lesson1

import ru.tinkoff.shmeleva.lesson1.car.Coupe
import ru.tinkoff.shmeleva.lesson1.car.Jeep

class CarDealership {
    constructor(jeep: Jeep){
        println(jeep.priceToString())
    }
    constructor(coupe: Coupe){
        println(coupe.priceToString())
    }
}