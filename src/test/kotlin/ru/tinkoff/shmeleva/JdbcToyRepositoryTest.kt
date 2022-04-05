package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import ru.tinkoff.shmeleva.db.JdbcToyRepositoryImpl
import javax.sql.DataSource

@JdbcTest
class JdbcToyRepositoryTest {

    @Autowired
    private lateinit var ds: DataSource

    @Test
    fun testRepository() {
        val result = JdbcToyRepositoryImpl(JdbcTemplate(ds)).getToys()
        assertEquals(3, result.size)
    }
}