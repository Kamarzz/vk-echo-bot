package com.komarzz.vkbotecho.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "vk")
class VkConfig {
    lateinit var confirmationCode: String
    lateinit var groupId: String
    lateinit var secret: String
    lateinit var token: String
    lateinit var apiVersion: String
}
