package com.example.xiaogetx.logic.network

import com.example.xiaogetx.logic.model.AddGoodsReq
import com.example.xiaogetx.logic.model.CommonRsp
import com.example.xiaogetx.logic.model.GoodsListRsp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface GoodsService {
    @GET("goods/queryList")
    fun queryGoodsList(): Call<GoodsListRsp>

    @PUT("goods/addGoods")
    fun addGoods(req: AddGoodsReq): Call<CommonRsp>
}