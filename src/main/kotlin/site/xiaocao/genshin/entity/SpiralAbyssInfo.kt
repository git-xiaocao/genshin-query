package me.xiaocao.entity

import  kotlinx.serialization.Serializable
import  kotlinx.serialization.SerialName

@Serializable
data class SpiralAbyssInfo(
    @SerialName("schedule_id")
    val scheduleId: Int,
    /**
     * 通关时间(时间戳 秒)
     * */
    @SerialName("start_time")
    val startTime: String,
    /**
     * 结束时间(时间戳 秒)
     * */
    @SerialName("end_time")
    val endTime: String,
    /**
     * 战斗次数
     * */
    @SerialName("total_battle_times")
    val totalBattleTimes: String,
    /**
     * 通关次数
     * */
    @SerialName("total_win_times")
    val totalWinTimes: String,
    /**
     * 最多到哪层(12-3)
     * */
    @SerialName("max_floor")
    val maxFloor: String,
    /**
     * 出战次数
     * */
    @SerialName("reveal_rank")
    val revealRank: List<Rank>,
    /**
     * 最多击破数(里面就一个)
     * */
    @SerialName("defeat_rank")
    val defeatRank: List<Rank>,
    /**
     * 最强一击(里面就一个)
     * */
    @SerialName("damage_rank")
    val damageRank: List<Rank>,
    /**
     *  最高承伤(里面就一个)
     * */
    @SerialName("take_damage_rank")
    val takeDamageRank: List<Rank>,
    /**
     *  最多E技能释放次数(里面就一个)
     * */
    @SerialName("normal_skill_rank")
    val normalSkillRank: List<Rank>,
    /**
     *  最多Q技能释放次数(里面就一个)
     * */
    @SerialName("energy_skill_rank")
    val energySkillRank: List<Rank>,
    /**
     * 每一层的信息
     * */
    val floors: List<Floor>,
    /**
     * 这一期总共获得了几颗星
     * */
    @SerialName("total_star")
    val totalStar: Int,
    @SerialName("is_unlock")
    val isUnlock: Boolean,
) {
    @Serializable
    data class Rank(
        @SerialName("avatar_id")
        val avatarId: Int,
        /**
         * 头像图标
         * */
        @SerialName("avatar_icon")
        val avatarIcon: String,
        val value: Int,
        /**
         * 星级
         * */
        val rarity: Int,
    )

    @Serializable
    data class Floor(
        /**
         * 层数
         * */
        val index: Int,
        /**
         * 空字符串
         * */
        val icon: String,
        @SerialName("is_unlock")
        val isUnlock: Boolean,
        /**
         * 字符串 "0"
         * */
        @SerialName("settle_time")
        val settleTime: String,
        /**
         * 获得了几颗星(快给我点star!)
         * */
        val star: Int,
        /**
         * 总共几颗星
         * */
        @SerialName("max_star")
        val maxStar: Int,
        val levels: List<Level>
    ) {
        @Serializable
        data class Level(
            val index: Int,
            /**
             * 获得了几颗星*/
            val star: Int,
            /**
             * 总共几颗星
             * */
            @SerialName("max_star")
            val maxStar: Int,
            val battles: List<Battle>,
        ) {
            @Serializable
            data class Battle(
                /**
                 * 第几个房间
                 * */
                val index: Int,
                /**
                 * 时间戳 秒
                 * */
                val timestamp: String,
                val avatars: List<Avatar>
            ) {
                @Serializable
                data class Avatar(
                    val id: Int,
                    /**
                     * 角色头像
                     * */
                    val icon: String,
                    /**
                     * 等级
                     * */
                    val level: Int,
                    /**
                     * 星级
                     * */
                    val rarity: Int,
                )
            }
        }
    }
}
