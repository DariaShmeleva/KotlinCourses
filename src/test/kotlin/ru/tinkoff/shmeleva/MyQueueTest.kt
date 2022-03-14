package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class MyQueueTest {
    private val myTestQueue = MyQueue<String>()

    @Test
    fun testOffering() {
        val result = myTestQueue.offer("a")

        val expected = true
        val actual = result
        assertEquals(expected, actual)
    }

    @Test
    fun testPoll() {

        myTestQueue.offer("a")
        myTestQueue.offer("b")
        myTestQueue.offer("c")

        assertEquals("a", myTestQueue.poll())
        assertEquals(2, myTestQueue.factSizePointer)
    }

    @Test
    fun testNullPoll() {

        val expected = null
        val actual = myTestQueue.poll()
        assertNull(expected, actual)
    }

    @Test
    fun testPeek() {

        myTestQueue.offer("a")
        myTestQueue.offer("b")
        myTestQueue.offer("c")

        val expected = "a"
        val actual = myTestQueue.peek()

        assertEquals(expected, actual)
        assertEquals(3, myTestQueue.queueArray.size)
    }

    @Test
    fun testNullPeek() {

        val expected = null
        val actual = myTestQueue.peek()

        assertEquals(expected, actual)
    }

    @Test
    fun testRemove() {

        myTestQueue.offer("a")
        myTestQueue.offer("b")
        myTestQueue.offer("c")

        assertEquals("a", myTestQueue.remove())
        assertEquals(2, myTestQueue.factSizePointer)
    }

    @Test
    fun testExceptionRemove() {

        assertThrows<NoSuchElementException> {
            myTestQueue.remove()
        }

    }

    @Test
    fun testElement() {

        myTestQueue.offer("a")
        myTestQueue.offer("b")
        myTestQueue.offer("c")

        assertEquals("a", myTestQueue.element())
    }

    @Test
    fun testExceptionElement() {

        assertThrows<NoSuchElementException> {
            myTestQueue.element()
        }

    }
}