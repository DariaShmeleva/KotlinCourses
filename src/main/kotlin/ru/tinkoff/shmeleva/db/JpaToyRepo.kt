package ru.tinkoff.shmeleva.db

import org.springframework.data.jpa.repository.JpaRepository

interface JpaToyRepo: JpaRepository<ToyDB, Int>