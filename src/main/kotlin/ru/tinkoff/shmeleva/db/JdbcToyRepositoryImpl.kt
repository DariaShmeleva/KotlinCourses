package ru.tinkoff.shmeleva.db

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Service

//@Primary
@Service
class JdbcToyRepositoryImpl(private val jdbcTemplate: JdbcTemplate) : ToyRepository {
    override fun addToy(toy: ToyDB) {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement("INSERT INTO toys (toyname, toytype, price) VALUES (?, ?, ?)")
            ps.setString(1, toy.toyname)
            ps.setString(2, toy.toytype)
            ps.setInt(3, toy.price)
            ps
        }
        jdbcTemplate.update(statementCreator)
    }

    override fun getToys(): List<ToyDB> {
        return jdbcTemplate.query("select * from toys") { rs, _ ->
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
            val ps = con.prepareStatement("SELECT * FROM toys WHERE toy_id=?")
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
            }[0]
    }
}