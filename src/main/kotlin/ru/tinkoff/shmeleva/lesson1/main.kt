package main.kotlin.ru.tinkoff.shmeleva.lesson1

import main.kotlin.ru.tinkoff.shmeleva.lesson1.car.Coupe
import main.kotlin.ru.tinkoff.shmeleva.lesson1.car.Jeep

fun main() {
    val jeep = Jeep("Toyota", "210", 2000, "forest")
    println(jeep.printWhereToGoOffRoad())
    println(jeep.printMaxSpeedInfo())
    jeep.fillUp()
    println(jeep.printPetrolInfo())
    jeep.fillUp(2)
    println(jeep.printPetrolInfo())
    val coupe = Coupe("Lamborghini", "350", 5000)
    println(coupe.printMaxSpeedInfo())
    coupe.drive()
    println(coupe.printPetrolInfo())
    println(coupe.printGasUpSound())

    val carDealership1 = CarDealership(jeep)
    val carDealership2 = CarDealership(coupe)
}