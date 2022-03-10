package ru.tinkoff.shmeleva.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JeepTest {

    @Test
    fun `when car drives petrol decreases 10`() {
        val jeep = Jeep("Toyota", "210", 2000, "forest")

        jeep.drive()

        val expected = "Jeep petrol reserve: Toyota has 100 liters"
        val actual = jeep.printPetrolInfo()
        assertEquals(expected, actual)
    }

    @Test
    fun `when car fills up petrol increases 10`() {
        val jeep = Jeep("Toyota", "210", 2000, "forest")

        jeep.fillUp()

        val expected = "Jeep petrol reserve: Toyota has 120 liters"
        val actual = jeep.printPetrolInfo()
        assertEquals(expected, actual)
    }

    @Test
    fun `when car fills up for exact quantity petrol increases exact quantity`() {
        val jeep = Jeep("Toyota", "210", 2000, "forest")

        jeep.fillUp(100)

        val expected = "Jeep petrol reserve: Toyota has 210 liters"
        val actual = jeep.printPetrolInfo()
        assertEquals(expected, actual)
    }
}