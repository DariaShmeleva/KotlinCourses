package ru.tinkoff.shmeleva

import ru.tinkoff.shmeleva.car.Car
import ru.tinkoff.shmeleva.car.Coupe
import ru.tinkoff.shmeleva.car.Jeep

class CarDealership {
    constructor(jeep: Jeep) {
        println(jeep.brand)
    }

    constructor(coupe: Coupe) {
        println(coupe.brand)
    }

    fun priceCar(car: Car): String = car.priceToString()

    fun printCarSound(car: Car): String = car.printGasUpSound()
}