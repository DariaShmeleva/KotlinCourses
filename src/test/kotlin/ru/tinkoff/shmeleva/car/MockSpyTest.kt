package ru.tinkoff.shmeleva.car

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.tinkoff.shmeleva.CarDealership


@ExtendWith(MockKExtension::class)
class MockSpyTest() {
    @MockK(relaxUnitFun = true)
    lateinit var jeep: Jeep

    @SpyK
    var coupe = Coupe("Ford Flacon", "150", 10000)

    @Test
    fun `mock test`() {
        every { jeep.printPetrolInfo() } returns "Jeep petrol reserve: Toyota has 1 000 000 liters"

        jeep.drive()

        val expected = "Jeep petrol reserve: Toyota has 1 000 000 liters"
        val actual = jeep.printPetrolInfo()
        assertEquals(expected, actual)
    }

    @Test
    fun `spy test`() {
        coupe.drive()

        val expected = "Coupe petrol reserve: Ford Flacon has 83 liters"
        val actual = coupe.printPetrolInfo()

        verify(exactly = 1) { coupe.drive() }
        assertEquals(expected, actual)
    }

    @Test
    fun `CarDealership price test`() {

        val carDealership = CarDealership(coupe)
        every { coupe.priceToString() } returns "Ford Flacon price: 10000$"

        val expected = "Ford Flacon price: 10000$"
        val actual = carDealership.priceCar(coupe)

        verify(exactly = 1) { carDealership.priceCar(coupe) }
        assertEquals(expected, actual)
    }

    @Test
    fun `CarDealership sound test`() {

        val carDealership = CarDealership(coupe)
        every { coupe.printGasUpSound() } returns "Wrom wrom"

        val expected = "Wrom wrom"
        val actual = carDealership.printCarSound(coupe)

        verify(exactly = 1) { coupe.printGasUpSound() }
        assertEquals(expected, actual)
    }

}

