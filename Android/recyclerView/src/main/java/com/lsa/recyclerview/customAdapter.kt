package com.lsa.recyclerview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter

class customAdapter(var context : Context, var template : Int, var data :ArrayList<customVO>)
    :Adapter<customViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        var template_view : View = LayoutInflater.from(context).inflate(template,parent,false)
        var VH : customViewHolder = customViewHolder(template_view)
        return VH
        //return customViewHolder ( 한줄로 적으려면 이렇게~
        //      LayoutInflater.from(context).inflate(template,parent,false)
        //)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        //ViewHolder에서 View들 꺼내다가 ArrayList에 저장된 데이터 꾸미는역할

        var tv_name:TextView = holder.tv_name
        var tv_url:TextView=holder.tv_url
        var customVO : customVO = data.get(position)

        tv_name.text = customVO.tv_name
        tv_url.text = customVO.tv_url

//        holder.tv_name.text = data.get(position).tv_name
//        holder.tv_url.text = data.get(position).tv_url
        //holder.tv_url.text = data.[position].tv_url
        holder.btn_go.setOnClickListener{
            var it = Intent(Intent.ACTION_VIEW, Uri.parse(data[position].tv_url))
            //Activity가 아닌 곳에서 Intent를 실행시키고 싶다면
            //새로운 태스크를 생성해야함!
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            //MainActivity 화면 정보를 생성자의 context 변수로 전달받았음!
            context.startActivity(it!!)
        }
    }

}
