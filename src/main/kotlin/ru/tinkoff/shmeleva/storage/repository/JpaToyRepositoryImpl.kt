package ru.tinkoff.shmeleva.storage.repository

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.storage.entity.ToyEntity

@Primary
@Service
class JpaToyRepositoryImpl(private val repository: JpaToyRepo) : ToyRepository {
    override fun addToy(toy: ToyEntity) {
        repository.save(toy)
    }

    override fun getToys(): List<ToyEntity> {
        return repository.findAll()
    }

    override fun getToy(id: Int): ToyEntity {
        return repository.findById(id).get()
    }
}