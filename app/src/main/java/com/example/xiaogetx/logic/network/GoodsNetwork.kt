package com.example.xiaogetx.logic.network

import com.example.xiaogetx.logic.model.AddGoodsReq
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object GoodsNetwork {

    private val goodsService = ServiceCreator.create(GoodsService::class.java)


    suspend fun getAllGoods() = goodsService.queryGoodsList().await();

    suspend fun addGoods(req: AddGoodsReq) = goodsService.addGoods(req).await();


    suspend fun queryClassify() = goodsService.queryClassifyList().await();


    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}