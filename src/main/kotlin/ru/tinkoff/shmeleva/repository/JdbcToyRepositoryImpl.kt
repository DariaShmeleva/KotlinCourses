package ru.tinkoff.shmeleva.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.db.ToyDB

//@Primary
@Service
class JdbcToyRepositoryImpl(private val jdbcTemplate: JdbcTemplate) : ToyRepository {
    override fun addToy(toy: ToyDB) {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(ADD_TOY)
            ps.setString(1, toy.toyname)
            ps.setString(2, toy.toytype)
            ps.setInt(3, toy.price)
            ps
        }
        jdbcTemplate.update(statementCreator)
    }

    override fun getToys(): List<ToyDB> {
        return jdbcTemplate.query(GET_ALL_TOYS) { rs, _ ->
            ToyDB(
                rs.getInt("toy_id"),
                rs.getString("toyname"),
                rs.getString("toytype"),
                rs.getInt("price")
            )
        }
    }

    override fun getToy(id: Int): ToyDB {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(GET_TOY)
            ps.setInt(1, id)
            ps
        }
        return jdbcTemplate
            .query(statementCreator) { rs, _ ->
                ToyDB(
                    rs.getInt("toy_id"),
                    rs.getString("toyname"),
                    rs.getString("toytype"),
                    rs.getInt("price")
                )
            }.first()
    }
    companion object {
        private const val ADD_TOY = "INSERT INTO toys (toyname, toytype, price) VALUES (?, ?, ?)"

        private const val GET_ALL_TOYS = "select * from toys"

        private const val GET_TOY = "SELECT * FROM toys WHERE toy_id=?"
    }
}