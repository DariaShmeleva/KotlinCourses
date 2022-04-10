package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import ru.tinkoff.shmeleva.repository.JdbcToyRepositoryImpl
import ru.tinkoff.shmeleva.db.ToyDB
import javax.sql.DataSource

@JdbcTest
class JdbcToyRepositoryTest {

    @Autowired
    private lateinit var ds: DataSource

    private lateinit var jdbcToyRepositoryImpl: JdbcToyRepositoryImpl

    @BeforeEach
    fun setUp() {
        jdbcToyRepositoryImpl = JdbcToyRepositoryImpl(JdbcTemplate(ds))
    }

    @Test
    fun getPerson() {

        val result = jdbcToyRepositoryImpl.getToy(1)

        assertEquals("Molnia", result.toyname)
        assertEquals("car", result.toytype)
        assertEquals(2000, result.price)
    }

    @Test
    fun getPersons() {

        val result = jdbcToyRepositoryImpl.getToys()

        assertEquals(3, result.size)
    }

    @Test
    fun savePerson() {

        jdbcToyRepositoryImpl.addToy(ToyDB(toyname = "Barbie", toytype = "doll", price = 1500))

        assertEquals(4, jdbcToyRepositoryImpl.getToys().size)
        assertEquals("Barbie", jdbcToyRepositoryImpl.getToys()[3].toyname)
        assertEquals(4, jdbcToyRepositoryImpl.getToys()[3].toy_id)
    }
}