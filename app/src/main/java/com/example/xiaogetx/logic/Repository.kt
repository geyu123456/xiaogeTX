package com.example.xiaogetx.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.example.xiaogetx.logic.dao.GoodsDao
import com.example.xiaogetx.logic.model.AddGoodsReq
import com.example.xiaogetx.logic.model.Goods
import com.example.xiaogetx.logic.model.GoodsListRsp
import com.example.xiaogetx.logic.network.GoodsNetwork
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

object Repository {


    fun queryAllGoods() = fire(Dispatchers.IO) {
        val rsp = GoodsNetwork.getAllGoods();
        if (rsp.code == 200) {
            Result.success(rsp.data)
        } else {
            Result.failure(RuntimeException(rsp.message))
        }

    }

    /**
     * 新增商品
     */
    fun addGoods(req:AddGoodsReq)= fire(Dispatchers.IO){
        val rsp = GoodsNetwork.addGoods(req);
        Log.d("add goods:{}",rsp.message)
        if (rsp.code == 200) {
            Result.success(rsp.data)
        } else {
            Result.failure(RuntimeException(rsp.message))
        }
    }

    /**
     * 查询分类列表
     */
        fun queryClassify()= fire(Dispatchers.IO){
        val rsp = GoodsNetwork.queryClassify();
        Log.d("add goods:{}",rsp.message)
        if (rsp.code == 200) {
            Result.success(rsp.data)
        } else {
            Result.failure(RuntimeException(rsp.message))
        }
    }

    fun saveGoods(goods: Goods) = GoodsDao.saveGoods(goods)


    fun getSavedGoods() = GoodsDao.getSavedGoods()


    fun isGoodsSaved() = GoodsDao.isGoodsSaved()


    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}