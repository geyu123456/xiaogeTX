package com.example.xiaogetx.ui.goods


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import android.widget.TextView
import com.example.xiaogetx.R


class GoodsClassifyAdapter(val context: Context,val  list: List<GoodsClassifyItem>) :BaseAdapter() {



    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "CutPasteId", "InflateParams")
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {

        val convertView = LayoutInflater.from(context).inflate(R.layout.classify_item, null)


        convertView?.let {

            val classifyId = it.findViewById(R.id.classifyId) as TextView
            val classifyName =it.findViewById(R.id.classifyName) as TextView
            classifyId.text = list[position].classifyId
            classifyName.text = list[position].classifyName
        }

        return convertView!!
    }
}