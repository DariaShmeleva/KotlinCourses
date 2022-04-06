package ru.tinkoff.shmeleva.db

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Primary
@Service
class JpaToyRepositoryImpl(private val repository: JpaToyRepo) : ToyRepository {
    override fun addToy(toy: ToyDB) {
        repository.save(toy)
    }

    override fun getToys(): List<ToyDB> {
        return repository.findAll()
    }

    override fun getToy(id: Int): ToyDB {
        return repository.findById(id).get()
    }
}