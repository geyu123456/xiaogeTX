package com.example.xiaogetx.ui.goods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.xiaogetx.R
import com.example.xiaogetx.logic.Repository
import com.example.xiaogetx.logic.model.AddGoodsReq
import com.example.xiaogetx.logic.network.GoodsService
import com.example.xiaogetx.logic.network.ServiceCreator
import kotlinx.android.synthetic.main.activity_add_goods.*

class AddGoodsActivity : AppCompatActivity() {
    private val goodsService = ServiceCreator.create(GoodsService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goods)

        addGoodsBtn.setOnClickListener {

            val name=goodsName.text.toString();
            val classifyName=goodsclassify.text.toString()
            val description=description.text.toString()
            val price=price.text.toString()
            val  picUrlList= listOf<String>()
            val req=AddGoodsReq(name,"1",description,price.toDouble(),picUrlList)
            Log.d("add goods:{}",req.toString())
            goodsService.addGoods(req)
        }



    }
}