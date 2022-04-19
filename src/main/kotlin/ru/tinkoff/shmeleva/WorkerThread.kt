package ru.tinkoff.shmeleva

import java.util.concurrent.LinkedBlockingQueue

class WorkerThread(
    private val taskQueue: LinkedBlockingQueue<Runnable>
) : Thread() {

    @Volatile
    var isStopped = false

    override fun run() {
        while (true) {
            var task: Runnable?
            synchronized(taskQueue) {
                while (taskQueue.isEmpty() && !isStopped) {
                    (taskQueue as Object).wait()
                }
                task = taskQueue.poll()
            }
            task?.run()
        }
    }
}