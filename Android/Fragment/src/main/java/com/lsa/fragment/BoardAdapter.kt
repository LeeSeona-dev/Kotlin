package com.lsa.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.lsa.fragment.vo.BoardDataVO

class BoardAdapter(var context : Context, var template :Int, var data:ArrayList<BoardDataVO>)
    :Adapter<BoardViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
//        var template_view : View = LayoutInflater.from(context).inflate(template,parent,false)
//        var VH : BoardViewHolder = BoardViewHolder(template_view)
//        return VH
        return  BoardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.board_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
//        var tv_boardTitle : TextView = holder.tv_boardTitle
//        var tv_boardId : TextView = holder.tv_boardId
//        var tv_boardLike : TextView = holder.tv_boardLike

        var BoardDataVO : BoardDataVO = data.get(position)
        holder.tv_boardId.text = BoardDataVO.tv_boardWriter
        holder.tv_boardLike.text = BoardDataVO.tv_Like.toString()
        holder.tv_boardTitle.text = BoardDataVO.tv_boardTitle

    }


}