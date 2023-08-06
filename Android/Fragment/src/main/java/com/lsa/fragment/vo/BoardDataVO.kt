package com.lsa.fragment.vo
import com.google.gson.annotations.SerializedName
data class BoardDataVO(

    @SerializedName("idx") var idx: Int?,
    @SerializedName("likeCnt") var tv_Like: Int?,
    @SerializedName("title") var tv_boardTitle: String,
    @SerializedName("content") var tv_boardContent:String?,
    @SerializedName("writer") var tv_boardWriter:String,
    @SerializedName("img") var iv_Like: String?

)
