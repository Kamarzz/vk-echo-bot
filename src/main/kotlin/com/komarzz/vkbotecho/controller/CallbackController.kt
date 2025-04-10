package com.komarzz.vkbotecho.controller

import com.komarzz.vkbotecho.config.VkConfig
import com.komarzz.vkbotecho.dto.CallbackRequest
import com.komarzz.vkbotecho.service.EchoService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/callback")
class CallbackController(
    private val config: VkConfig,
    private val echoService: EchoService
) {
    private val log = LoggerFactory.getLogger(CallbackController::class.java)

    @PostMapping
    fun handleCallback(@RequestBody request: CallbackRequest): String {
        return when (request.type) {
            "confirmation" -> {
                log.info("Handling confirmation")
                config.confirmationCode
            }

            "message_new" -> {
                if (request.secret != config.secret) {
                    log.warn("Invalid secret: ${request.secret}")
                    return "not allowed"
                }

                val message = request.`object`?.message
                if (message == null) {
                    log.warn("Missing message in object")
                    return "bad request"
                }

                echoService.echoBack(message)
                "ok"
            }

            else -> {
                log.info("Unsupported event type: ${request.type}")
                "unsupported"
            }
        }
    }
}
