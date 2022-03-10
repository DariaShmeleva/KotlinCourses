package ru.tinkoff.shmeleva

import ru.tinkoff.shmeleva.car.Coupe
import ru.tinkoff.shmeleva.car.Jeep

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

    CarDealership(jeep)
    CarDealership(coupe)
}