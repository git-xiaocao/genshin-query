package me.xiaocao.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityExploration(
    val id: Int,
    val level: Int,
    @SerialName("exploration_percentage")
    val explorationPercentage: Int,
    val icon: String,
    val name: String,
)
