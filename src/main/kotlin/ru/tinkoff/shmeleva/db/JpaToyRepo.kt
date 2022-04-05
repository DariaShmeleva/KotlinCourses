package ru.tinkoff.shmeleva.db

import org.springframework.data.jpa.repository.JpaRepository
import ru.tinkoff.shmeleva.toyStore.RequestToy

interface JpaToyRepo: JpaRepository<Toy, Int>