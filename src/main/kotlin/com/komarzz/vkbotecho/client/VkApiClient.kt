package com.komarzz.vkbotecho.client

import com.komarzz.vkbotecho.config.VkConfig
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class VkApiClient(
    private val config: VkConfig
) {
    private val log = LoggerFactory.getLogger(VkApiClient::class.java)
    private val restTemplate = RestTemplate()

    fun sendMessage(peerId: Long, message: String) {
        val uri: URI = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("api.vk.com")
            .path("/method/messages.send")
            .queryParam("access_token", config.token)
            .queryParam("v", config.apiVersion)
            .queryParam("peer_id", peerId)
            .queryParam("message", message)
            .queryParam("random_id", System.currentTimeMillis())
            .build()
            .toUri()

        val response = restTemplate.getForObject(uri, String::class.java)
        log.info("VK response: $response")
    }

}
