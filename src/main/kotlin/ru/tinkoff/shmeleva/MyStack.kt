package ru.tinkoff.shmeleva

class MyStack<T> : MyCollection() {

    var stackArray = arrayOfNulls<Any>(initSize)
    private var top = -1

    override fun resize() {
        initSize += SIZE_INCREASING
        val newArray = arrayOfNulls<Any>(initSize)
        System.arraycopy(stackArray, 0, newArray, 0, factSizePointer)
        stackArray = newArray
    }

    //push() — добавляет элемент на верх стека. Когда мы отправляем карту в сброс,
    // она ложится поверх сброшенных ранее карт;
    fun push(element: T) {
        if (factSizePointer == initSize) resize()
        stackArray[++top] = element
        factSizePointer++
    }

    //pop() — удаляет верхний элемент из стека и возвращает его. Этот метод идеально подходит
    // для реализации механики “игрок берет карту”
    fun pop(): T {
        factSizePointer--
        return (stackArray[top--] ?: throw NoSuchElementException()) as T
    }

    //peek() — возвращает верхний элемент стека, но не удаляет его из стека
    fun peek(): T = (stackArray[top] ?: throw NoSuchElementException()) as T
}