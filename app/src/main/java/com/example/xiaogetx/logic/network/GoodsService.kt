package com.example.xiaogetx.logic.network

import com.example.xiaogetx.logic.model.GoodsListRsp
import retrofit2.Call
import retrofit2.http.GET

interface GoodsService {
    @GET("goods/queryList")
    fun queryGoodsList():Call<GoodsListRsp>
}