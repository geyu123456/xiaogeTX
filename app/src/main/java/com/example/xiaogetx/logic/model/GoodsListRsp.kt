package com.example.xiaogetx.logic.model

class GoodsListRsp(val code: Int, val message: String, val data: List<Goods>)


class Goods(
    val goodsId: String,
    val name: String,
    val classifyId: String,
    val classifyName: String,
    val description: String,
    val price: Double,
    val imageUrls: List<String>,
    val mainImage: String
);