package site.xiaocao.genshin.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QueryResult<T>(
    @SerialName("retcode")
    val retCode: Int?,
    val message: String,
    val data: T?,
) {
    val success: Boolean get() = retCode == 0
}