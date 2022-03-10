package ru.tinkoff.shmeleva.car

class Coupe(
    override var brand: String,
    override val speed: String,
    override var price: Int,
    var gasUpSound: String = "Wrom wrom"
) :
    Car {

    private var petrol: Int = 90

    override fun printGasUpSound(): String = "$gasUpSound"

    override fun printMaxSpeedInfo(): String {
        var petrolInfo = if (petrol == 0) "But we need petrol" else "It's too fast for Russian roads!"
        return "Wow, $brand maximum speed is $speed kph! $petrolInfo"
    }

    override fun fillUp() {
        petrol += 11;
    }

    override fun drive() {
        if (petrol > 7) {
            petrol -= 7
        } else {
            print("Fill up the tank")
        }
    }

    override fun printPetrolInfo(): String = "Coupe petrol reserve: $brand has $petrol liters"

    override fun priceToString(): String = "$brand price: $price$"

}
