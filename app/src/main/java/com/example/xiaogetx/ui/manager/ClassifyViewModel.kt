package com.example.xiaogetx.ui.manager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.xiaogetx.logic.Repository
import com.example.xiaogetx.logic.model.Goods
import com.example.xiaogetx.ui.goods.GoodsClassifyItem

class ClassifyViewModel :ViewModel(){

    private val searchLiveData = MutableLiveData<String>()
    val classifyList=ArrayList<GoodsClassifyItem>()

    val classifyLiveData = Transformations.switchMap(searchLiveData) {
        Repository.queryClassify()
    }


    fun searchClassies(query: String) {
        searchLiveData.value = query
    }
}