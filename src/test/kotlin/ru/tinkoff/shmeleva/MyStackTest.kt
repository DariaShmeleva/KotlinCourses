package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyStackTest {
    private val myTestStack = MyStack<String>()

    @Test
    fun testPush() {
        myTestStack.push("a")
        myTestStack.push("b")

        assertEquals(2, myTestStack.factSizePointer)
    }

    @Test
    fun testPop() {
        myTestStack.push("a")
        myTestStack.push("b")

        assertEquals("b", myTestStack.pop())
        assertEquals(1, myTestStack.factSizePointer)
    }

    @Test
    fun testPeek() {
        myTestStack.push("a")
        myTestStack.push("b")

        assertEquals("b", myTestStack.peek())
        assertEquals(2, myTestStack.factSizePointer)
    }
}