package ru.tinkoff.shmeleva.storage.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.tinkoff.shmeleva.storage.entity.ToyEntity

interface JpaToyRepo: JpaRepository<ToyEntity, Int>