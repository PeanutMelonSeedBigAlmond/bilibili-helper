package xyz.cssxsh.bilibili.data

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
data class BiliTempInfo(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val data: JsonObject? = null,
    @SerialName("message")
    val message: String,
    @SerialName("ttl")
    val ttl: Int? = null,
    @SerialName("msg")
    val msg: String? = null
) {
    fun <T> transferTo(deserializer: DeserializationStrategy<T>) =
        Json.decodeFromJsonElement(deserializer, requireNotNull(data) { message })
}

