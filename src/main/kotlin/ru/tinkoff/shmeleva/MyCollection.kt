package ru.tinkoff.shmeleva

abstract class MyCollection {
    var initSize = 1
    var factSizePointer = 0
    val SIZE_INCREASING = 1

    abstract fun resize()

}