package ru.tinkoff.shmeleva

import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.tinkoff.shmeleva.client.ToyClient
import ru.tinkoff.shmeleva.dto.ToyRequest

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ToyTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var toyClient: ToyClient

    @BeforeAll
    fun setUp() {
        coEvery { toyClient.toyProcessed(any()) } returns ToyRequest("Molnia", "car", 2000)
        runBlocking {
            mockMvc.perform(
                post("/best-toy")
                    .param("name", "Molnia1")
                    .param("type", "car")
                    .param("price", "2000")
            )
        }
    }

    @Test
    fun postToy() {

        mockMvc.perform(
            post("/best-toy")
                .param("name", "Molnia")
                .param("type", "car")
                .param("price", "2000")
        ).andExpect(status().isOk)
    }

    @Test
    fun getToy() {

        mockMvc.perform(get("/best-toy/1"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Molnia")))
            .andExpect(content().string(containsString("car")))
            .andExpect(content().string(containsString("2000")))
    }
}