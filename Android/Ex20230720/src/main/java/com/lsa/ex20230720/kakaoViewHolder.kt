package com.lsa.ex20230720

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class kakaoViewHolder(var itemView:View) :ViewHolder(itemView) {

    //자바버전
    //class kakaoViewHolder extends ViewHolder{
    //  kakaoViewHolder(View itemView){ //생성자
    //      super(itemView); //상위클래스의 생성자 호출(super. -> 메서드호출)
    //  }
    //}

    var img : ImageView
    var tv_name : TextView
    var tv_msg : TextView
    var tv_time : TextView

    // default 생성자(매개변수 하나도 없는 생성자, 무조건 실행)

    init {
        img = itemView.findViewById(R.id.img)
        tv_msg = itemView.findViewById(R.id.tv_msg)
        tv_name=itemView.findViewById(R.id.tv_name)
        tv_time=itemView.findViewById(R.id.tv_time)
    }


}