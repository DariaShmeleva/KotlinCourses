package ru.tinkoff.shmeleva.db

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.toyStore.RequestToy
import java.util.*

@Primary
@Service
class JpaToyRepositoryImpl(private val repository: JpaToyRepo): ToyRepository {
    override fun addToy(requestToy: RequestToy) {
        repository.save(Toy(Random(100).nextInt(), requestToy.toyname, requestToy.toytype, requestToy.price))
    }

    override fun getToys() = repository.findAll()



}