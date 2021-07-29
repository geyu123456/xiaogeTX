package com.example.xiaogetx.ui.manager


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xiaogetx.R
import com.example.xiaogetx.logic.model.Goods


class GoodsAdapter(private  val goodsListFragment: GoodsListFragment,private  val goodsList:List<Goods>):RecyclerView.Adapter<GoodsAdapter.ViewHolder>() {

    inner  class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val goodsName:TextView=view.findViewById(R.id.goodsName)
        val  goodPic:ImageView=view.findViewById(R.id.goodsUrl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goods_item, parent, false)
        val holder = ViewHolder(view)
        return  holder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goodsItem = goodsList[position]
        holder.goodsName.text = goodsItem.name
        Glide.with(goodsListFragment).load(goodsItem.imageUrls.get(0)).into(holder.goodPic)

        //holder.goodPic.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return goodsList.size
    }
}