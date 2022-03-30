package site.xiaocao.genshin

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import site.xiaocao.genshin.dto.QueryResult
import site.xiaocao.genshin.dto.QueryRole
import site.xiaocao.genshin.entity.PlayInfo
import me.xiaocao.entity.SpiralAbyssInfo
import okhttp3.Interceptor
import okhttp3.Response
import site.xiaocao.genshin.entity.DailyNote

class GenshinQuery(
    private val salt: String,
    private val version: String,
    private val type: String,
    private val cookie: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = chain.request().newBuilder().apply {
            //Firefox
            header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0")
            header("x-rpc-client_type", type)
            header("x-rpc-app_version", version)
            header("DS", Utils.dynamicSecret(salt, request.url, request.body?.toString()))
            header("Cookie", cookie)
        }.build()

        return chain.proceed(newRequest)
    }


    private val httpClient = HttpClient(OkHttp) {
        engine {
            addInterceptor(this@GenshinQuery)
        }
        install(ContentNegotiation) {
            json(Json {
                //指定是否应漂亮地打印结果 JSON
                prettyPrint = true
                //宽松模式
                isLenient = true
                //指定是否应编码 Kotlin 属性的默认值
                encodeDefaults = true
                //是否应忽略输入 JSON 中遇到的未知属性
                ignoreUnknownKeys = true
                //启用将不正确的 JSON 值强制为默认属性值
                coerceInputValues = true
                //指定 Json 实例是否使用 JsonNames 注释。
                useAlternativeNames = false
            })
        }


    }

    /**
     * 查询玩家信息
     * @param uid 玩家的uid
     * @param server 服务器名 cn_qd01 cn_gf01
     * */
    suspend fun playInfo(uid: String, server: String): QueryResult<PlayInfo> {
        val response = httpClient.get {
            url("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/index")
            parameter("role_id", uid)
            parameter("server", server)
        }
        return response.body()
    }

    /**
     * 查询深渊信息
     * @param type "1" 这一期 "2" 上一期
     * @param uid 玩家的uid
     * @param server 服务器名 cn_qd01 cn_gf01
     * */
    suspend fun spiralAbyssInfo(type: String, uid: String, server: String): QueryResult<SpiralAbyssInfo> {
        val response = httpClient.get {
            url("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/spiralAbyss")
            parameter("schedule_type", type)
            parameter("server", server)
            parameter("role_id", uid)
        }
        return response.body()
    }

    //没测试
    suspend fun characters(uid: String, server: String, characterIds: List<Int>): String {
        val response = httpClient.post {
            url("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/character")
            setBody(
                QueryRole(
                    characterIds = characterIds,
                    roleId = uid,
                    server = server,
                )
            )
        }
        return response.body()
    }

    /**
     * 查询实时便笺
     * @param uid 玩家的uid
     * @param server 服务器名 cn_qd01 cn_gf01
     * */
    suspend fun dailyNote(uid: String, server: String): QueryResult<DailyNote> {
        val response = httpClient.get {
            url("https://api-takumi-record.mihoyo.com/game_record/app/genshin/api/dailyNote")
            parameter("role_id", uid)
            parameter("server", server)
        }
        return response.body()
    }
}