package com.lsa.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlin.io.path.fileVisitor


class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view =  inflater.inflate(R.layout.fragment_2, container, false)

        //component 가져오기
        var etUrl : EditText = view.findViewById(R.id.etUrl)
        var btnUrl : Button = view.findViewById(R.id.btnUrl)

        btnUrl.setOnClickListener{
            //버튼을 클릭하면 사용자가 작성한 url 값 가져오기
            val url = etUrl.text.toString()

            //SharedPreference 생성하기
            //MODE_PRIVATE : 내부 캐시에 저장 -> 노출 되지 않음
            val spf = requireActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE)

            // - editor 사용
            val editor =  spf.edit()

            //url 값 저장(SharedPreference -> 내부 메모리처럼 쓰임,내부에서 공유)
            editor.putString("url",url)
            editor.commit()
        }
        return view
    }


}