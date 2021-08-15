package com.example.xiaogetx.logic.model

import java.util.*

class GoodsListRsp(val code: Int, val message: String, val data: List<Goods>)

class CommonRsp(val code: Int, val message: String, val data:  Objects)


class Goods(
    val goodsId: String,
    val name: String,
    val classifyId: String,
    val classifyName: String,
    val description: String,
    val price: Double,
    val imageUrls: List<String>,
    val mainImage: String
)


class AddGoodsReq(
    val name: String,
    val classifyId: String,

    val description: String,
    val price: Double,
    val imageUrls: List<String>

)