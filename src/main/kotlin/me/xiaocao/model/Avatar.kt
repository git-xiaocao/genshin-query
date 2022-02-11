package me.xiaocao.model

import kotlinx.serialization.Serializable

@Serializable
data class Avatar(
    val id: Int,
    val image: String,
    val name: String,
    val element: String,
    val fetter: Int,
    val level: Int,
    val rarity: Int,
)
