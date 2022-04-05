package ru.tinkoff.shmeleva.db

import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.toyStore.RequestToy

//@Primary
@Service
class JdbcToyRepositoryImpl(private val jdbcTemplate: JdbcTemplate): ToyRepository {
    override fun addToy(requestToy: RequestToy) {
        TODO("Not yet implemented")
    }

    override fun getToys(): List<Toy> {
        return jdbcTemplate.query("select * from toys") { rs, _ ->
            Toy(
                rs.getInt("toy_id"),
                rs.getString("toyname"),
                rs.getString("toytype"),
                rs.getInt("price")
            )
        }
    }
}