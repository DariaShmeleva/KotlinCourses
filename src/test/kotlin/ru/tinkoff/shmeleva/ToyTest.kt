package ru.tinkoff.shmeleva

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.tinkoff.shmeleva.toyStore.ToyClient
import ru.tinkoff.shmeleva.toyStore.ToyRepository
import org.hamcrest.CoreMatchers.containsString
import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import ru.tinkoff.shmeleva.toyStore.RequestToy
import ru.tinkoff.shmeleva.toyStore.ResponseToy

@SpringBootTest
@AutoConfigureMockMvc
class MockMvcApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private val objectMapper = ObjectMapper()

    @MockkBean
    private lateinit var toyClient: ToyClient

    @MockkBean
    private lateinit var toyRepository: ToyRepository

    @Test
    fun toyAddedToList() {
        every { toyClient.enrichToyInfo(any()) } returns responseToy
        every { toyRepository.addToy(any()) } returns Unit

        mockMvc.perform(
            post("/toys/add")
                .content(objectMapper.writeValueAsString(requestToy))
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Барби"))
            .andExpect(jsonPath("$.type").value("Кукла"))
            .andExpect(jsonPath("$.price").value("2000"))
    }

    @Test
    fun getToySuccessfully() {
        every { toyRepository.getToy(any()) } returns responseToy

        mockMvc.perform(get("/toys/get/0"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.name").value("Барби"))
            .andExpect(jsonPath("$.type").value("Кукла"))
            .andExpect(jsonPath("$.price").value("2000"))
    }

    @Test
    fun errorMessageWhenGetToyFails() {
        every { toyRepository.getToy(any()) } throws illegalArgumentException

        mockMvc.perform(get("/toys/get/0"))
            .andExpect(status().is4xxClientError)
            .andExpect(content().string(containsString("Отсутствует игрушка с таким штрихкодом")))
    }

    @Test
    fun listOfLowerPriceToys() {
        every { toyRepository.getAllLowerPrice(any()) } returns list

        mockMvc.perform(
            get("/toys/getAllLowerPrice")
                .param("price", "1900")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].name").value("Молния"))
            .andExpect(jsonPath("$[0].type").value("Машинка"))
            .andExpect(jsonPath("$[0].price").value("1500"))
            .andExpect(jsonPath("$[1].name").value("Мишка"))
            .andExpect(jsonPath("$[1].type").value("Плюшевая"))
            .andExpect(jsonPath("$[1].price").value("1800"))
    }

    @Test
    fun errorMessageWhenGetAllLowerPriceFails() {
        every { toyRepository.getAllLowerPrice(any()) } throws illegalStateException

        mockMvc.perform(
            get("/toys/getAllLowerPrice")
                .param("price", "2000")
        )
            .andExpect(status().is5xxServerError)
            .andExpect(content().string(containsString("Игрушки дешевле отсутствуют")))
    }

    companion object {
        private val requestToy = RequestToy("Барби", 2000)
        private val responseToy = ResponseToy("Барби", "Кукла", 2000)
        private val illegalArgumentException = IllegalArgumentException("Отсутствует игрушка с таким штрихкодом")
        private val list = listOf(
            ResponseToy("Молния", "Машинка", 1500),
            ResponseToy("Мишка", "Плюшевая", 1800),
            ResponseToy("Барби", "Кукла", 2000),
            ResponseToy("Кораблик", "Радиоуправляемая", 3500)
        )
        private val illegalStateException = IllegalStateException("Игрушки дешевле отсутствуют")
    }
}