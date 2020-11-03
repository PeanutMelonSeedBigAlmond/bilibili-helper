package xyz.cssxsh.mirai.bilibili.api

import io.ktor.client.request.*
import io.ktor.http.*
import xyz.cssxsh.mirai.bilibili.BilibiliClient
import xyz.cssxsh.mirai.bilibili.data.BiliAccInfo

suspend fun BilibiliClient.accInfo(
    uid: Long,
    url: String = BilibiliApi.ACC_INFO
): BiliAccInfo = useHttpClient { client ->
    client.get(url) {
        header(HttpHeaders.Origin, BilibiliApi.SPACE)
        header(HttpHeaders.Referrer, BilibiliApi.SPACE)

        parameter("mid", uid)
        parameter("jsonp", "jsonp")
        parameter("tid", 0)
    }
}