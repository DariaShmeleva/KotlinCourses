package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.tinkoff.shmeleva.Transliteration.cyr2lat

internal class ServiceCatsTest {
    val serviseCats = ServiceCats()
    val cats = listOf(
        Cat("Пушок", "абиссинская", FurType.Shorthair, 23000, 2),
        Cat("Муся", "британская", FurType.Longhair, 37000, 3),
        Cat("Грогу", "сфинкс", FurType.NoHair, 30000, 4),
        Cat("Пуся", "манчкин", FurType.Longhair, 25000, 6),
        Cat("Коготок", "бенгал", FurType.Shorthair, 27000, 2)
    )

    @Test
    fun convertToEnglishToDollarsAndSort() {
        val expected = listOf(
            Cat("Pushok", "abissinskaya", FurType.Shorthair, 219, 2),
            Cat("Pusya", "manchkin", FurType.Longhair, 238, 6),
            Cat("Kogotok", "bengal", FurType.Shorthair, 257, 2),
            Cat("Grogu", "sfinks", FurType.NoHair, 285, 4),
            Cat("Musya", "britanskaya", FurType.Longhair, 352, 3)
        )

        val actual = serviseCats.catsTransformation(cats)
        assertEquals(expected, actual)
    }

    @Test
    fun groupByFurType() {
        val expected = mapOf(
            FurType.Shorthair to listOf(
            Cat("Пушок", "абиссинская", FurType.Shorthair, 23000, 2),
            Cat("Коготок", "бенгал", FurType.Shorthair, 27000, 2)
            ),
            FurType.Longhair to listOf(
                Cat("Муся", "британская", FurType.Longhair, 37000, 3),
                Cat("Пуся", "манчкин", FurType.Longhair, 25000, 6)
            ),
            FurType.NoHair to listOf(
            Cat("Грогу", "сфинкс", FurType.NoHair, 30000, 4)
        )
        )

        val actual = serviseCats.catsGroupBy(cats)
        assertEquals(expected, actual)
    }

    @Test
    fun find3SpesialPrice() {
        val expected = listOf(
            Cat("Муся", "британская", FurType.Longhair, 37000, 3),
            Cat("Грогу", "сфинкс", FurType.NoHair, 30000, 4),
            Cat("Пуся", "манчкин", FurType.Longhair, 25000, 6)
        )

        val actual = serviseCats.catsFind(cats)
        assertEquals(expected, actual)
    }
}