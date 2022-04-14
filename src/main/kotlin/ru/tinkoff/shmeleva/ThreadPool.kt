package ru.tinkoff.shmeleva

import java.util.*
import  java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(threadQuantity: Int, maxThreadQuantity: Int) : Executor {

    val threadList = LinkedList<WorkerThread?>()

    private val taskQueue = LinkedBlockingQueue<Runnable>()

    init {
        if (threadQuantity < 1 || threadQuantity > maxThreadQuantity)
            throw IllegalArgumentException("Недоступное количество потоков!")
        for (i in 1..threadQuantity) {
            val thread = WorkerThread(taskQueue)
            threadList.add(thread)
            thread.start()
        }
    }

    override fun execute(command: Runnable) {
        synchronized(taskQueue) {
            taskQueue.add(command)
            (taskQueue as Object).notify()
        }
    }

    fun shutdown() {
        for (i in 0 until threadList.size) {
                threadList[i]!!.interrupt()
        }
    }
}