package me.xiaocao.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayerStatistics(
    @SerialName("active_day_number")
    val activeDayNumber: Int,
    @SerialName("achievement_number")
    val achievementNumber: Int,
    @SerialName("win_rate")
    val winRate: Int,
    //地球仪?
    @SerialName("anemoculus_number")
    val anemoculusNumber: Int,
    //风眼?
    @SerialName("geoculus_number")
    val geoculusNumber: Int,
    @SerialName("avatar_number")
    val avatarNumber: Int,
    @SerialName("way_point_number")
    val wayPointNumber: Int,
    @SerialName("domain_number")
    val domainNumber: Int,
    @SerialName("spiral_abyss")
    val spiralAbyss: String,
    @SerialName("precious_chest_number")
    val preciousChestNumber: Int,
    @SerialName("luxurious_chest_number")
    val luxuriousChestNumber: Int,
    @SerialName("exquisite_chest_number")
    val exquisiteChestNumber: Int,
    @SerialName("common_chest_number")
    val commonChestNumber: Int,
)
