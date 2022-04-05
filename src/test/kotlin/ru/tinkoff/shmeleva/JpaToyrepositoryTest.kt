package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import ru.tinkoff.shmeleva.db.JpaToyRepo
import ru.tinkoff.shmeleva.toyStore.RequestToy

@DataJpaTest
class JpaToyrepositoryTest {

    @Autowired
    private lateinit var repository : JpaToyRepo

   // @Test
   // fun testRepository(){

      //  var result = repository.findAll().toList()
      //  Assertions.assertEquals(3, result.size)

   // }
}