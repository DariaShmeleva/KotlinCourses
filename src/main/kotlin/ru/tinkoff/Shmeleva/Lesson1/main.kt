package main.kotlin.ru.tinkoff.Shmeleva.Lesson1

fun main() {
    val jeep = Jeep("Toyota", "210", 2000, "forest")
    jeep.goToOffRoad()
    jeep.maxSpeedInfo()
    jeep.fillUp()
    jeep.petrolInfo()
    jeep.fillUp(2)
    jeep.petrolInfo()
    val coupe = Coupe("Lamborghini", "350", 5000)
    coupe.maxSpeedInfo()
    coupe.drive()
    coupe.petrolInfo()
    coupe.gasUp()

    val carDealership1 = CarDealership(jeep)
    val carDealership2 = CarDealership(coupe)
}