package main.kotlin.ru.tinkoff.Shmeleva.Lesson1

class CarDealership {
    constructor(jeep: Jeep){
       jeep.priceToString()
    }
    constructor(coupe: Coupe){
        coupe.priceToString()
    }
}