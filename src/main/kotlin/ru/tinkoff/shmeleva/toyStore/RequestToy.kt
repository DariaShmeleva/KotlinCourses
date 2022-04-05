package ru.tinkoff.shmeleva.toyStore

data class RequestToy(
    val toyname: String,
    val toytype: String,
    val price: Int
)