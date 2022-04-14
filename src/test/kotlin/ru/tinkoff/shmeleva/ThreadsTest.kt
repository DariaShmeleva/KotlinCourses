package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ThreadsTest {

    val threadPool = ThreadPool(5, 7)

    @Test
    fun threadPoolTest() {

        assertDoesNotThrow {
            for (i in 0..5) {
                threadPool.execute {
                    println("$i - задача выполняется...")
                }
            }
            threadPool.shutdown()
        }
    }

    @Test
    fun exceptionWhenThreadsQuantityIsUnavailable() {
        val result = assertThrows<IllegalArgumentException> {
            ThreadPool(5, 2)
        }
        assertEquals("Недоступное количество потоков!", result.message)
    }
}