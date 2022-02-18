package main.kotlin.ru.tinkoff.Shmeleva.Lesson1

class Coupe(override val brand: String, override val speed: String, override val price: Int, var gasUpSound: String = "Wrom wrom") : Car {

    private var petrol: Int = 90

    fun gasUp() = println("$gasUpSound")

    override fun maxSpeedInfo() {
        var petrolInfo = if (petrol == 0) "But we need petrol" else "It's too fast for Russian roads!"
        println("Wow, $brand maximum speed is $speed kph! $petrolInfo")

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

    override fun petrolInfo() = "$petrol".petrolReserve()

    override fun priceToString() = println("$brand price: $price")

}
