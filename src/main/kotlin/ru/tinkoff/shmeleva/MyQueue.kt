package ru.tinkoff.shmeleva

class MyQueue<T> : MyCollection() {

    var queueArray = arrayOfNulls<Any>(initSize)
    private var head = 0
    private var tail = -1

    override fun resize() {
        initSize += SIZE_INCREASING
        val newArray = arrayOfNulls<Any>(initSize)
        System.arraycopy(queueArray, 0, newArray, 0, factSizePointer)
        queueArray = newArray
    }

    private fun add(element: T): Boolean {
        if (factSizePointer >= initSize) resize()
        queueArray[++tail] = element
        factSizePointer++
        return true
    }

    //Е element() возвращает элемент из головы очереди. Элемент не удаляется. Если очередь пуста,
    // инициируется исключение NoSuchElementException.
    fun element(): T = (queueArray[head] ?: throw NoSuchElementException()) as T

    //Е remove() - удаляет элемент из головы очереди, возвращая его. Инициирует исключение NoSuchElementException,
    // если очередь пуста.
    fun remove(): T {
        val el = queueArray[head++]
        factSizePointer--
        return (el ?: throw NoSuchElementException()) as T
    }

    //Е peek() - возвращает элемент из головы очереди. Возвращает null, если очередь пуста. Элемент не удаляется.
    fun peek(): T? = (queueArray[head] as T?)

    //Е роll() - возвращает элемент из головы очереди и удаляет его. Возвращает null, если очередь пуста.
    fun poll(): T? {
        val el = queueArray[head++]
        factSizePointer--
        return el as T?
    }

    //boolean offer(Е оbj) - пытается добавить оbj в очередь. Возвращает true, если оbj добавлен, и false в противном случае.
    fun offer(element: T): Boolean = add(element)
}