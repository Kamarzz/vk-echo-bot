package com.komarzz.vkbotecho.service

import com.komarzz.vkbotecho.client.VkApiClient
import com.komarzz.vkbotecho.dto.VkMessage
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EchoService(
    private val vkApiClient: VkApiClient
) {
    private val log = LoggerFactory.getLogger(EchoService::class.java)

    fun echoBack(message: VkMessage) {
        log.info("Echoing message from ${message.fromId}: ${message.text}")
        val response = "Вы сказали: " + message.text
        vkApiClient.sendMessage(message.peerId, response)
    }
}
