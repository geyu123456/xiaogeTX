package com.example.xiaogetx.ui.goods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.xiaogetx.MainActivity
import com.example.xiaogetx.R

import com.example.xiaogetx.logic.model.AddGoodsReq
import com.example.xiaogetx.logic.network.GoodsNetwork
import com.example.xiaogetx.ui.manager.ClassifyViewModel

import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_add_goods.*
import kotlinx.android.synthetic.main.fragment_place.*
import kotlinx.coroutines.runBlocking

import java.lang.RuntimeException
import kotlin.concurrent.thread

class AddGoodsActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProviders.of(this).get(ClassifyViewModel::class.java) }


    private  lateinit var adpter: GoodsClassifyAdapter
    private fun initView(){


      /*  var list= ArrayList<GoodsClassifyItem>()
        list.add(GoodsClassifyItem("1","鲜花"))
        list.add(GoodsClassifyItem("2","布置"))*/


        adpter= GoodsClassifyAdapter(this,viewModel.classifyList)
        spClassify.adapter=adpter
       /* adpter=ArrayAdapter(this,R.layout.classify_item,list)

        spClassify.adapter=adpter*/


    }




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goods)
        initView()
        viewModel.searchClassies("")
        viewModel.classifyLiveData.observe(this, Observer{ result ->
            val places = result.getOrNull()
            if (places != null) {
                viewModel.classifyList.clear()
                viewModel.classifyList.addAll(places)
                adpter.notifyDataSetChanged()
            } else {

                result.exceptionOrNull()?.printStackTrace()
            }
        })

        addGoodsBtn.setOnClickListener {
            val name = goodsName.text.toString();

            val description = descriptionEt.text.toString()
            val price = priceEt.text.toString()
            val picUrlList = listOf<String>("123")
            val req = AddGoodsReq(name, "1", description, price.toDouble(), picUrlList)

            Log.d("add goods:{}", Gson().toJson(req))
            thread {
                runBlocking {
                    val rsp = GoodsNetwork.addGoods(req);
                    Log.d("add goods:{}", rsp.message)
                    if (rsp.code == 1) {
                        Log.d("message:{}","操作成功")
                        Result.success(rsp.data)

                    } else {
                        Result.failure(RuntimeException(rsp.message))
                    }
                }
            }

            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
}