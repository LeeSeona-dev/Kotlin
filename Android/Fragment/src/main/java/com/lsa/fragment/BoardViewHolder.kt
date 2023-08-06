package com.lsa.fragment

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class BoardViewHolder(var itemView:View):ViewHolder(itemView) {

    var tv_boardTitle : TextView
    var tv_boardId: TextView
    var tv_boardLike : TextView

    init {
        tv_boardTitle = itemView.findViewById(R.id.tv_boardTitle)
        tv_boardId = itemView.findViewById(R.id.tv_boardId)
        tv_boardLike = itemView.findViewById(R.id.tv_boardLike)

    }
}