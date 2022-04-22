package ru.tinkoff.shmeleva.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import ru.tinkoff.shmeleva.client.ToyClient
import ru.tinkoff.shmeleva.dto.ToyRequest
import ru.tinkoff.shmeleva.dto.ToyResponse
import ru.tinkoff.shmeleva.storage.repository.ToyRepository
import ru.tinkoff.shmeleva.util.toDto
import ru.tinkoff.shmeleva.util.toModel

@Service
class ToyService(
    private val toyRepository: ToyRepository,
    private val toyClient: ToyClient
) {

    fun addToy(toy: ToyRequest) {
        CoroutineScope(Dispatchers.Default).launch {
            val processedToy = toyClient.toyProcessed(toy)
            withContext(Dispatchers.IO) {
                toyRepository.save(processedToy.toModel())
            }
        }
    }

    fun getToy(id: Int): ToyResponse {
        return toyRepository.findById(id).get().toDto()
    }
}