package com.komarzz.vkbotecho.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CallbackRequest(
    val type: String,

    @field:JsonProperty("group_id")
    val groupId: Long,

    val secret: String? = null,
    val `object`: CallbackObject? = null
)
