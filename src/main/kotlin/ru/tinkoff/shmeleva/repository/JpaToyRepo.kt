package ru.tinkoff.shmeleva.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.tinkoff.shmeleva.db.ToyDB

interface JpaToyRepo: JpaRepository<ToyDB, Int>