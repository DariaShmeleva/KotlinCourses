package ru.tinkoff.shmeleva.car

interface Car {

    val brand: String

    val speed: String

    val price: Int

    fun printMaxSpeedInfo(): String = "Wow, $brand maximum speed is $speed kph!"

    fun fillUp()

    fun drive()

    fun printPetrolInfo(): String

    fun priceToString(): String

    fun printGasUpSound(): String
}