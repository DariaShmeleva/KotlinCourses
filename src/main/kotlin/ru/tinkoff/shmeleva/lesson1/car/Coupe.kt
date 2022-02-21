package main.kotlin.ru.tinkoff.shmeleva.lesson1.car

class Coupe(override val brand: String, override val speed: String, override val price: Int, var gasUpSound: String = "Wrom wrom") : Car {

    private var petrol: Int = 90

    fun printGasUpSound():String = "$gasUpSound"

    override fun printMaxSpeedInfo():String {
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

    override fun printPetrolInfo():String = "Coupe petrol reserve: $brand has $petrol liters"

    override fun priceToString():String = "$brand price: $price$"

}
