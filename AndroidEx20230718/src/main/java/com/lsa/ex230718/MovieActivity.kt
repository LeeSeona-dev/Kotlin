package com.lsa.ex230718

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MovieActivity : AppCompatActivity() {

    lateinit var  listView: ListView
    lateinit var btnMovie : Button

    lateinit var reqQueue: RequestQueue
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        //component 가져오기
        listView = findViewById(R.id.lvMovie)
        btnMovie = findViewById(R.id.btnMovie)

        //RequestQueue 생성하기
        reqQueue = Volley.newRequestQueue(this)

        var movieList = ArrayList<MovieVO>()

        //버튼 클릭되면 영화 api를 통해 20230717 영화 순위 데이터 요청 후 응답값(순위,영화제목,개봉날짜) 처리
        //한 영화에 대한 데이터 MovieVO (data class)로 묶어서

        //1. 전체 json 데이터 가져오기
        //**요청은 한번만 하면됨

        btnMovie.setOnClickListener {
            val request = StringRequest(
                Request.Method.GET,
                "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230718",
                {
                    response->
                    Log.d("response",response.toString())
                    val result = JSONObject(response)
                    val boxOfficeResult = result.getJSONObject("boxOfficeResult")

                    val dailyBoxOfficeList = boxOfficeResult.getJSONArray("dailyBoxOfficeList")

                    for(i in 0 until dailyBoxOfficeList.length()){
                      var dailyBoxOfficeItem =dailyBoxOfficeList.getJSONObject(i)
                        val rank = dailyBoxOfficeItem.getInt("rank")
                        val movieNm = dailyBoxOfficeItem.getString("movieNm")
                        val movieDt = dailyBoxOfficeItem.getString("openDt")

                        movieList.add(MovieVO(rank, movieNm, movieDt))
                        Log.d("rank", rank.toString())

                    }
                    val adapter= ArrayAdapter<MovieVO>(applicationContext, android.R.layout.simple_list_item_1, movieList)
                    listView.adapter = adapter
                },
                {
                    error->
                    Log.d("error",error.toString())
                    Toast.makeText(this,"error 발생", Toast.LENGTH_SHORT).show()
                }
            )

            //여러번 요청할 경우 캐시 누적됨,
            //이전 결과가 있어도 새로 요청하여 응답을 보여주고싶은 경우
            request.setShouldCache(false)
            reqQueue.add(request)
        }

    }
}