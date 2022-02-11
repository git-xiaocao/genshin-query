import kotlinx.coroutines.runBlocking
import me.xiaocao.GenshinQuery
import kotlin.test.Test


class SimpleTest {

    @Test
    fun test() {
        val genshinQuery = GenshinQuery(
            salt = "xV8v4Qu54lUKrEYFZkJhB8cuOh9Asafs",
            version = "2.11.1",
            type = "5",
            cookie = "login_uid=1; login_ticket=2;"
        )

        runBlocking {
            //cn_qd01
            //cn_gf01
            val result = genshinQuery.queryPlayInfo("", "cn_gf01")
            if (result.success) {
                val playInfo = result.data
                println(playInfo)
            } else {
                println("查询失败:${result.message}")
            }
        }

    }
}