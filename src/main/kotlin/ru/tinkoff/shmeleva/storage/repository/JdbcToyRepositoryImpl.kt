package ru.tinkoff.shmeleva.storage.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.storage.entity.ToyEntity

//@Primary
@Service
class JdbcToyRepositoryImpl(private val jdbcTemplate: JdbcTemplate) : ToyRepository {
    override fun addToy(toy: ToyEntity) {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(ADD_TOY)
            ps.setString(1, toy.name)
            ps.setString(2, toy.type)
            ps.setInt(3, toy.price)
            ps
        }
        jdbcTemplate.update(statementCreator)
    }

    override fun getToys(): List<ToyEntity> {
        return jdbcTemplate.query(GET_ALL_TOYS) { rs, _ ->
            ToyEntity(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("type"),
                rs.getInt("price")
            )
        }
    }

    override fun getToy(id: Int): ToyEntity {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(GET_TOY)
            ps.setInt(1, id)
            ps
        }
        return jdbcTemplate
            .query(statementCreator) { rs, _ ->
                ToyEntity(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("price")
                )
            }.first()
    }
    companion object {
        private const val ADD_TOY = "INSERT INTO toys (name, type, price) VALUES (?, ?, ?)"

        private const val GET_ALL_TOYS = "select * from toys"

        private const val GET_TOY = "SELECT * FROM toys WHERE id=?"
    }
}