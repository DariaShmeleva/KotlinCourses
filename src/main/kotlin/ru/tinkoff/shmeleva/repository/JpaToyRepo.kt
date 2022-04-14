package ru.tinkoff.shmeleva.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.tinkoff.shmeleva.entity.entity.ToyEntity

interface JpaToyRepo: JpaRepository<ToyEntity, Int>