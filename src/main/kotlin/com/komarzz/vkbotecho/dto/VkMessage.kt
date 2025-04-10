package com.komarzz.vkbotecho.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class VkMessage(

    @field:JsonProperty("from_id")
    val fromId: Long,

    @field:JsonProperty("peer_id")
    val peerId: Long,

    val text: String
)
