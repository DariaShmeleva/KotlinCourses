package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.DirtiesContext
import ru.tinkoff.shmeleva.storage.repository.JpaToyRepo
import ru.tinkoff.shmeleva.storage.entity.ToyEntity

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
internal class JpaToyRepositoryTest {

    @Autowired
    private lateinit var repository: JpaToyRepo

    @BeforeEach
    fun setUp() {
        repository.save(ToyEntity(name = "Molnia", type = "car", price = 2000))
        repository.save(ToyEntity(name = "Korablik", type = "radiotoy", price = 2500))
        repository.save(ToyEntity(name = "HelloKitty", type = "fluffy toy", price = 1700))
    }

    @Test
    fun getPerson() {

        val result = repository.findById(1).get()

        assertEquals("Molnia", result.name)
        assertEquals(2000, result.price)
    }

    @Test
    fun getPersons() {

        val result = repository.findAll()

        assertEquals(3, result.size)
    }

    @Test
    fun savePerson() {

        repository.save(ToyEntity(name = "Barbie", type = "doll", price = 1500))

        assertEquals(4, repository.findAll().size)
        assertEquals("Barbie", repository.findAll()[3].name)
        assertEquals(4, repository.findAll()[3].id)
    }
}