package com.lsa.ex20230720

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

//생성자로 데이터 전달 받기!
class ChildEvent(var data:ArrayList<kakaoVO>, var adapter: kakaoAdapter) : ChildEventListener {
    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 추가 감지
        //ArrayList에 추가된 데이터 추가하고 Adapter 새로고침
        // snapshot => firebase database에 저장된 데이터
        //=> json 구조로 응답함 => kakaoVO 형태로 변환
        var temp : kakaoVO? = snapshot.getValue(kakaoVO::class.java)
        data.add(temp!!) //temp가 null일수도 있음을 표기
        adapter.notifyDataSetChanged()

    }

    override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 변경 감지
//        data.add(snapshot.getValue(kakaoVO::class.java)as kakaoVO)
//        adapter.notifyDataSetChanged()
    }

    override fun onChildRemoved(snapshot: DataSnapshot) {
        //데이터 삭제 감지
    }

    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
        //데이터 이동 감지
    }

    override fun onCancelled(error: DatabaseError) {
        //데이터 문제 발생 감지
    }
}