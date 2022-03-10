package ru.tinkoff.shmeleva.car

class Jeep(
    override val brand: String,
    override val speed: String,
    override val price: Int,
    private val offRoad: String
) : Car {

    var petrol: Int = 110

    fun printWhereToGoOffRoad(): String = "$brand go to $offRoad."

    override fun printGasUpSound(): String = "BEEEEEP!"

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

    override fun printPetrolInfo(): String = "Jeep petrol reserve: $brand has $petrol liters"

    override fun priceToString(): String = "$brand price: $price$"

}