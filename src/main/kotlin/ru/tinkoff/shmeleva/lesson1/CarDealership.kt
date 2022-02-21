package main.kotlin.ru.tinkoff.shmeleva.lesson1

import main.kotlin.ru.tinkoff.shmeleva.lesson1.car.Coupe
import main.kotlin.ru.tinkoff.shmeleva.lesson1.car.Jeep

class CarDealership {
    constructor(jeep: Jeep){
        println(jeep.priceToString())
    }
    constructor(coupe: Coupe){
        println(coupe.priceToString())
    }
}