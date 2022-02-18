package main.kotlin.ru.tinkoff.Shmeleva.Lesson1

class Jeep(override val brand: String, override val speed: String, override val price: Int, val offRoad: String) : Car {

    private var petrol: Int = 110

    fun goToOffRoad() {
        println("$brand go to $offRoad.")
    }

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

    override fun petrolInfo() = "$petrol".petrolReserve()

    override fun priceToString() = println("$brand price: $price")

}