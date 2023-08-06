package com.lsa.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class Fragment1 : Fragment() {

    //View 생성(**)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_1, container, false)

        //WebView Component 가져오기
         var wv : WebView = view.findViewById(R.id.wv)

        //SharedPreferences 생성
        val spf = requireActivity().getSharedPreferences(
            "mySPF",
            Context.MODE_PRIVATE
        )

        //보여주고 싶은 web url 지정
       // val url = "https://smhrd.or.kr/"
        //++ SharedPreference 안에 저장된 url 꺼내서 사용
        // 가지고 오고싶은 값의 key값, 만약없을때의 기본값
        val url = spf.getString("url","https://www.google.com")

        //web setting
        val ws = wv.settings
        //1. javascript 사용 가능하도록 허용 추가하기
        ws.javaScriptEnabled = true

        //WebView 클라이언트 설정
        wv.webViewClient = WebViewClient()

        //WebView에 url 적용
        // url? -> null값 허용한다는 의미 ,
        // url!! -> null 값이 들어오지 않는다는 의미 (현재 기본값 넣어놨으므로 !! 사용)
        wv.loadUrl(url!!)

        return view
    }

}