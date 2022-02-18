package main.kotlin.ru.tinkoff.Shmeleva.Lesson1

interface Car {

    val brand: String

    val speed: String

    val price: Int

    fun maxSpeedInfo() = println("Wow, $brand maximum speed is $speed kph!")

    fun fillUp()

    fun drive()

    fun petrolInfo()

    fun String.petrolReserve() {
        println("Petrol reserve: $brand has $this liters")
    }

    fun priceToString()
}