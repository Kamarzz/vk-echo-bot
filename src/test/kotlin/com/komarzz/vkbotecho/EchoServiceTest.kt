package com.komarzz.vkbotecho

import com.komarzz.vkbotecho.client.VkApiClient
import com.komarzz.vkbotecho.dto.VkMessage
import com.komarzz.vkbotecho.service.EchoService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class EchoServiceUnitTest {

    private val mockClient = mock<VkApiClient>()
    private val echoService = EchoService(mockClient)

    @Test
    fun `should echo back message`() {
        val msg = VkMessage(fromId = 123L, peerId = 456L, text = "Привет")

        echoService.echoBack(msg)

        verify(mockClient).sendMessage(456L, "Вы сказали: Привет")
    }
}

