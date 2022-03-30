package site.xiaocao.genshin.entity

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class DailyNote(
    /**
     * 当前树脂
     * */
    @SerialName("current_resin")
    val currentResin: Int,
    /**
     * 最大树脂
     * */
    @SerialName("max_resin")
    val maxResin: Int,
    /**
     * 树脂恢复时间
     * */
    @SerialName("resin_recovery_time")
    val resinRecoveryTime: Int,
    /**
     * 任务完成数量
     * */
    @SerialName("finished_task_num")
    val finishedTaskNum: Int,
    /**
     * 总任务数量
     * */
    @SerialName("total_task_num")
    val totalTaskNum: Int,
    /**
     * 是否收到额外的任务奖励
     * */
    @SerialName("is_extra_task_reward_received")
    val isExtraTaskRewardReceived: Boolean,
    /**
     * 剩余树脂折扣数(世界BOSS)
     * */
    @SerialName("remain_resin_discount_num")
    val remainResinDiscountNum: Int,
    /**
     * 树脂折扣数量限制(世界BOSS)
     * */
    @SerialName("resin_discount_num_limit")
    val resinDiscountNumLimit: Int,
    /**
     * 当前探险次数
     * */
    @SerialName("current_expedition_num")
    val currentExpeditionNum: Int,
    /**
     * 最大探险次数
     * */
    @SerialName("max_expedition_num")
    val maxExpeditionNum: Int,
    /**
     * 探险
     * */
    val expeditions: List<Expedition>,
    /**
     * 壶里面的那个硬币当前数量
     * */
    @SerialName("current_home_coin")
    val currentHomeCoin: Int,
    /**
     * 壶里面的那个硬币最大数量
     * */
    @SerialName("max_home_coin")
    val maxHomeCoin: Int,
    /**
     * 壶里面的那个硬币恢复时间
     * */
    @SerialName("home_coin_recovery_time")
    val homeCoinRecoveryTime: String,
    /**
     * 日历
     * */
    @SerialName("calendar_url")
    val calendarUrl: String,
    /**
     * 参量质变仪
     * */
    val transformer: Transformer,

    ) {
    /**
     * 探险
     * */
    @Serializable
    data class Expedition(
        /**
         * 头像侧图标
         * */
        @SerialName("avatar_side_icon")
        val avatarSideIcon: String,
        /**
         * 状态
         * Finished是已完成
         * */
        val status: String,

        /**
         * 剩余时间
         * */
        @SerialName("remained_time")
        val remainedTime: String,
    )

    /**
     * 参量质变仪
     * */
    @Serializable
    data class Transformer(
        /**
         * 获得
         * */
        val obtained: Boolean,
        /**
         * 刷新时间
         * */
        @SerialName("recovery_time")
        val recoveryTime: RecoveryTime,
        /**
         * url
         * */
        val wiki: String,
    ) {
        @Serializable
        data class RecoveryTime(
            /**
             * 天
             * */
            @SerialName("Day")
            val day: Int,
            /**
             * 小时
             * */
            @SerialName("Hour")
            val hour: Int,
            /**
             * 分
             * */
            @SerialName("Minute")
            val minute: Int,
            /**
             * 秒
             * */
            @SerialName("Second")
            val second: Int,
            /**
             * 刷新好了
             * */
            val reached: Boolean,
        )
    }
}
