package ru.tinkoff.shmeleva

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.tinkoff.shmeleva.component.Producer
import ru.tinkoff.shmeleva.storage.entity.EventEntity
import ru.tinkoff.shmeleva.storage.repository.EventRepository
import ru.tinkoff.shmeleva.util.EventStatus
import ru.tinkoff.shmeleva.util.EventType
import java.lang.Thread.sleep

@SpringBootTest
internal class EventTest {

    @Autowired
    private lateinit var producer: Producer

    @Autowired
    private lateinit var eventRepository: EventRepository

    @BeforeEach
    fun setUp() {
        eventRepository.save(
            EventEntity(
                1,
                EventType.EMAIL,
                "Hello from email",
                EventStatus.NEW
            )
        )
    }


    @Test
    fun updateEventStatus() {

        producer.produceEvents()
        sleep(200)


        val result = eventRepository.findById(1).get()
        Assertions.assertAll(
            { assertEquals("Hello from email", result.body) },
            { assertEquals(EventStatus.DONE, result.status) },
            { assertEquals(EventType.EMAIL, result.type) }
        )
    }
}