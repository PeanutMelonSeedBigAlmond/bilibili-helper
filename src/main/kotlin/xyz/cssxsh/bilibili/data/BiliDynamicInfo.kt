package xyz.cssxsh.bilibili.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import xyz.cssxsh.bilibili.data.dynamic.*
import xyz.cssxsh.bilibili.data.user.*

@Serializable
data class BiliDynamicInfo(
    @SerialName("attentions")
    val attentions: UserAttentions? = null,
    @SerialName("card")
    val card: DynamicInfo,
    @SerialName("_gt_")
    private val gt: Int,
    @SerialName("result")
    private val result: Int
)