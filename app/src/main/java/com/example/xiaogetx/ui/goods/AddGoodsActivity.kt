package com.example.xiaogetx.ui.goods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.example.xiaogetx.MainActivity
import com.example.xiaogetx.R

import com.example.xiaogetx.logic.model.AddGoodsReq
import com.example.xiaogetx.logic.network.GoodsNetwork
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_add_goods.*
import kotlinx.coroutines.runBlocking

import java.lang.RuntimeException
import kotlin.concurrent.thread

class AddGoodsActivity : AppCompatActivity() {


    private  lateinit var adpter: SpinnerAdapter
    private fun initView(){
        val list= listOf("鲜花","布置")
        adpter=ArrayAdapter(this,R.layout.classify_item,list)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goods)
        initView()

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