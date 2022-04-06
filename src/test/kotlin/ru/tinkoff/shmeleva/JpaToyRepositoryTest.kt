package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.DirtiesContext
import ru.tinkoff.shmeleva.db.JpaToyRepo
import ru.tinkoff.shmeleva.db.ToyDB

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
internal class JpaToyRepositoryTest {

    @Autowired
    private lateinit var repository: JpaToyRepo

    @BeforeEach
    fun setUp() {
        repository.save(ToyDB(toyname = "Molnia", toytype = "car", price = 2000))
        repository.save(ToyDB(toyname = "Korablik", toytype = "radiotoy", price = 2500))
        repository.save(ToyDB(toyname = "HelloKitty", toytype = "fluffy toy", price = 1700))
    }

    @Test
    fun getPerson() {

        val result = repository.findById(1).get()

        assertEquals("Molnia", result.toyname)
        assertEquals(2000, result.price)
    }

    @Test
    fun getPersons() {

        val result = repository.findAll()

        assertEquals(3, result.size)
    }

    @Test
    fun savePerson() {

        repository.save(ToyDB(toyname = "Barbie", toytype = "doll", price = 1500))

        assertEquals(4, repository.findAll().size)
        assertEquals("Barbie", repository.findAll()[3].toyname)
        assertEquals(4, repository.findAll()[3].toy_id)
    }
}