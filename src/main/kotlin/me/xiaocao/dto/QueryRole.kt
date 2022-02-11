package me.xiaocao.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QueryRole(
    @SerialName("character_ids")
    val characterIds: List<Int>,
    @SerialName("role_id")
    val roleId: String,
    val server: String,
)
