package com.lsa.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class customViewHolder(var itemView:View):ViewHolder(itemView) {

    var tv_name : TextView
    var tv_url : TextView
    var btn_go : Button

    init {

        tv_url = itemView.findViewById(R.id.tv_url)
        tv_name=itemView.findViewById(R.id.tv_name)
        btn_go=itemView.findViewById(R.id.btn_go)
    }

}