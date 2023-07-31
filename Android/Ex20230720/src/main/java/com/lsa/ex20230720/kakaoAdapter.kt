package com.lsa.ex20230720

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter

class kakaoAdapter(var context : Context, var template : Int, var data: ArrayList<kakaoVO>)
    : Adapter<kakaoViewHolder>(){//kakaoViewHolder가 viewHolder 상속받고 있기 때문에
    //extends Adapter<kakaoViewHolder>

    //상위 클래스인 Adapter클래스가 추상클래스이기 때문이다.
    // =>추상클래스를 상속받는 하위클래스는 반드시 추상메서드를 오버라이딩(재정의) 해야함
    //=> 추상메서드:
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kakaoViewHolder {
        //자바 : public kakaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){}

        //ViewHolder 생성하는 메서드 ->  RecyclerView 만들때 한번만 호출!
        // ViewHorlder:템플릿에 있는 뷰를 저장하는 역할

        //xml로 만들어진 컨텐츠 => kt(java) 객체로 만드는 것 : Inflater!!!
        //대표적으로 findViewById가 있음

        //ViewHolder를 생성할 때 Template.xml을 View타입으로 변환해서 전달
        //context:Activity로써 할 수 있는 일들을 context라 함
        var template_View : View = LayoutInflater.from(context).inflate(template, parent, false)

        var VH : kakaoViewHolder = kakaoViewHolder(template_View)

        return VH

    }

    override fun getItemCount(): Int {
        //자바 : public Int getItemCount(){}
        //전체 아이템의 개수를 리턴하는 곳
        //return 5 =>
        return data.size //전체 메시지의 개수만큼 리턴!
    }

    //클래스를 설계할때 자료형 정확히 결정x
    //자료형은 개발자가 결정 -> 제네릭 기법
    override fun onBindViewHolder(holder: kakaoViewHolder, position: Int) {
        //이전에 쓰던 ViewHolder에서 View들 꺼내다가 ArrayList에 저장된 데이터들로 꾸미는 역할
        //OnCreateViewHolder는 한번 생성 -> ViewHolder에 keep -> onBindViewHolder에서 가져와서
        //내용물만 변경한다.
        //onBindViewHolder 는 getItemCount숫자 만큼 계속 호출!
        //position 숫자번째 데이터로 꾸밈

        var img:ImageView = holder.img
        var tv_msg : TextView = holder.tv_msg

        var kakaoMessage : kakaoVO = data.get(position)

        img.setImageResource(kakaoMessage.imgID!!)
        tv_msg.text = kakaoMessage.msg

        //ver2.
        holder.tv_name.text = data.get(position).name
        holder.tv_time.text = data.get(position).time


    }
}