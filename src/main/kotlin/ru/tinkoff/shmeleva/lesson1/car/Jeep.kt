package ru.tinkoff.shmeleva.lesson1.car

import ru.tinkoff.shmeleva.lesson1.car.Car

class Jeep(override val brand: String, override val speed: String, override val price: Int, val offRoad: String) :
    Car {

    private var petrol: Int = 110

    fun printWhereToGoOffRoad():String = "$brand go to $offRoad."

    override fun fillUp() {
        petrol += 10;
    }

    fun fillUp(morePatrol: Int) {
        petrol += morePatrol;
    }

    override fun drive() {
        if (petrol > 10) {
            petrol -= 10
        } else {
            print("Fill up the tank")
        }
    }

    override fun printPetrolInfo():String = "ru.tinkoff.shmeleva.lesson1.car.Jeep petrol reserve: $brand has $petrol liters"

    override fun priceToString():String = "$brand price: $price$"

}