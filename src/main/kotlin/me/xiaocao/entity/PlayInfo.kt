package me.xiaocao.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlayInfo(
    val avatars: List<Avatar>,
    val stats: PlayerStatistics,
    /**
     * 大世界探索
     * */
    @SerialName("world_explorations")
    val worldExplorations: List<WorldExploration>,
    /**
     * 壶
     * */
    val homes: List<Home>,
) {
    @Serializable
    data class PlayerStatistics(
        /**
         * 活跃天数
         * */
        @SerialName("active_day_number")
        val activeDayNumber: Int,
        /**
         * 成就数量
         * */
        @SerialName("achievement_number")
        val achievementNumber: Int,
        @SerialName("win_rate")
        val winRate: Int,
        /**
         * 风神瞳
         * */
        @SerialName("anemoculus_number")
        val anemoculusNumber: Int,
        /**
         * 岩神瞳
         * */
        @SerialName("geoculus_number")
        val geoculusNumber: Int,
        /**
         * 角色数量
         * */
        @SerialName("avatar_number")
        val avatarNumber: Int,
        /**
         * 传送点
         * */
        @SerialName("way_point_number")
        val wayPointNumber: Int,
        /**
         * 秘境
         * */
        @SerialName("domain_number")
        val domainNumber: Int,
        /**
         * 深渊层数
         * */
        @SerialName("spiral_abyss")
        val spiralAbyss: String,
        /**
         * 珍贵宝箱数量
         * */
        @SerialName("precious_chest_number")
        val preciousChestNumber: Int,
        /**
         * 华丽宝箱数量
         * */
        @SerialName("luxurious_chest_number")
        val luxuriousChestNumber: Int,
        @SerialName("exquisite_chest_number")
        /**
         * 精致宝箱数量
         * */
        val exquisiteChestNumber: Int,
        @SerialName("common_chest_number")
        /**
         * 普通宝箱数量
         * */
        val commonChestNumber: Int,
    )

    @Serializable
    data class WorldExploration(
        val level: Int,
        //探索百分比(÷10才是对应的)
        @SerialName("exploration_percentage")
        val explorationPercentage: Int,
        val icon: String,
        val name: String,
        val type: String,
        val id: Int,
    )

    @Serializable
    data class Home(
        val level: Int,
        /**
         * 历史访客次数
         * */
        @SerialName("visit_num")
        val visitNum: Int,
        /**
         * 最高洞天仙力
         * */
        @SerialName("comfort_num")
        val comfortNum: Int,
        /**
         * 获得摆设数
         * */
        @SerialName("item_num")
        val itemNum: Int,
        val name: String,
        val icon: String,
        /**
         * 等级名称
         * */
        @SerialName("comfort_level_name")
        val comfortLevelName: String,
        /**
         * 等级图标
         * */
        @SerialName("comfort_level_icon")
        val comfortLevelIcon: String,
    )

    @Serializable
    data class Avatar(
        val id: Int,
        /**
         * 头像
         * */
        val image: String,
        val name: String,
        /**
         * 元素
         * */
        val element: String,
        val fetter: Int,
        /**
         * 等级
         * */
        val level: Int,
        /**
         * 星级
         * */
        val rarity: Int,
        /**
         * 命星
         * */
        @SerialName("actived_constellation_num")
        val activedConstellationNum: Int,
        /**
         * 卡片头像
         * */
        @SerialName("card_image")
        val cardImage: String,
        @SerialName("is_chosen")
        val isChosen: Boolean
    )
}