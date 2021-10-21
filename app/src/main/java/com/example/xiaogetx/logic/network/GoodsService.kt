package com.example.xiaogetx.logic.network

import com.example.xiaogetx.logic.model.AddGoodsReq
import com.example.xiaogetx.logic.model.CommonRsp
import com.example.xiaogetx.logic.model.GoodsListRsp
import com.example.xiaogetx.ui.goods.GoodsClassifyItem
import retrofit2.Call
import retrofit2.http.*

interface GoodsService {
    @GET("goods/queryList")
    fun queryGoodsList(): Call<GoodsListRsp>


    @PUT("goods/addGoods")
    fun addGoods(@Body req: AddGoodsReq): Call<CommonRsp<String>>


    @GET("goods/queryClassifyList")
    fun queryClassifyList(): Call<CommonRsp<List<GoodsClassifyItem>>>
}