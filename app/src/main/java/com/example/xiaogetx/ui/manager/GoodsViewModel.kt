package com.example.xiaogetx.ui.manager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.xiaogetx.logic.Repository
import com.example.xiaogetx.logic.dao.GoodsDao
import com.example.xiaogetx.logic.model.Goods

class GoodsViewModel:ViewModel() {

    private val searchLiveData = MutableLiveData<String>()


    val goodsList=ArrayList<Goods>()


    val placeLiveData = Transformations.switchMap(searchLiveData) {
        Repository.queryAllGoods()
    }


    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun saveGoods(goods: Goods) = Repository.saveGoods(goods)


    fun getSavedGoods() = Repository.getSavedGoods()


    fun isGoodsSaved() = Repository.isGoodsSaved()

}