package me.xiaocao.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.xiaocao.model.Avatar
import me.xiaocao.model.CityExploration
import me.xiaocao.model.PlayerStatistics
import me.xiaocao.model.WorldExploration

@Serializable
data class PlayInfo(
    val avatars: List<Avatar>,
    val stats: PlayerStatistics,
    @SerialName("city_explorations")
    val cityExplorations: List<CityExploration>,
    @SerialName("world_explorations")
    val worldExplorations: List<WorldExploration>,
)
