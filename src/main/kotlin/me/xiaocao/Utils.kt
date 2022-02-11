package me.xiaocao

import okhttp3.HttpUrl
import java.security.MessageDigest
import kotlin.random.Random

object Utils {
    fun dynamicSecret(salt: String, url: HttpUrl, body: String?): String {
        val query = url.query
        val time = System.currentTimeMillis() / 1000
        val random = randomString(6)
        val check = md5HexString("salt=$salt&t=$time&r=$random&b=${body ?: ""}&q=$query")

        return "$time,$random,$check"
    }

    private fun md5HexString(content: String): String {
        val md = MessageDigest.getInstance("MD5")
        md.update(content.toByteArray())
        val md5Bytes = md.digest()

        return StringBuilder().apply {
            md5Bytes.forEach { append(String.format("%02x", it.toUByte().toInt())) }
        }.toString()
    }

    private fun randomString(length: Int): String {
        val random = Random(System.currentTimeMillis())
        val keySet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

        return StringBuilder().apply {
            for (i in 0 until length)
                append(keySet[random.nextInt(keySet.length)])
        }.toString()

    }
}