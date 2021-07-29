package com.example.xiaogetx.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.example.xiaogetx.XiaogeTXApplication
import com.example.xiaogetx.logic.model.Goods
import com.example.xiaogetx.logic.model.GoodsListRsp
import com.google.gson.Gson

object GoodsDao {


    fun saveGoods(goods: Goods) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(goods))
        }
    }

    fun getSavedGoods(): Goods {
        val placeJson = sharedPreferences().getString("goods", "")
        return Gson().fromJson(placeJson, Goods::class.java)
    }

    fun isGoodsSaved() = sharedPreferences().contains("goods")

    private fun sharedPreferences() =
        XiaogeTXApplication.context.getSharedPreferences("xiaogeTX", Context.MODE_PRIVATE)
}