package ru.tinkoff.shmeleva.toyStore

data class ResponseToy(
    val toyId: Int,
    val toyname: String,
    val toytype: String,
    val price: Int
)