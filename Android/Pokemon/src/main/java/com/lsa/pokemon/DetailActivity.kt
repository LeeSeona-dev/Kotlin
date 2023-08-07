package com.lsa.pokemon

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {
    lateinit var ivPokemon :ImageView

    lateinit var tvPokeNm : TextView
    lateinit var reqQueue : RequestQueue
    lateinit var tvType1 : TextView
    lateinit var tvType2 : TextView
    lateinit var tvWeight : TextView
    lateinit var tvHeight : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // component 가져오기 -> 이미지, 텍스트
        ivPokemon = findViewById(R.id.ivPoke)
        tvPokeNm = findViewById(R.id.tvPokeNm)
        tvType1=findViewById(R.id.tvType1)
        tvType2 = findViewById(R.id.tvType2)
        tvWeight = findViewById(R.id.tvWeight)
        tvHeight = findViewById(R.id.tvWeight)


        reqQueue = Volley.newRequestQueue(this@DetailActivity)

        var list = ArrayList<String>()
        //intent -> 이름, 이미지경로(Glide) , id(상세정보 가져올때 사용) 가져오기
        val intent = getIntent()
        val id = intent.getIntExtra("id", -1)
        val img = intent.getStringExtra("img")
        val name = intent.getStringExtra("name")

        tvPokeNm.text = name
        Glide.with(this).load(img).into(ivPokemon)

        val detailUrl = "https://pokeapi.co/api/v2/pokemon/$id"

        //response -> JSONObject형태로
        // typeList = result.getJSONArray("types")로 가져오기
        // type.getJSONObject(index).getJSONObject("type").getString("name")
        //      index -> 0, 1 (1번째 없을수도 , 어떻게 처리할건지)
        val request = object : StringRequest(
            Request.Method.GET,
            detailUrl,
            { response ->
                Log.d("response", response.toString())
                val result = JSONObject(response)
                val types = result.getJSONArray("types")

                //val type1 = types.getJSONObject(i).getJSONObject("type").getString("name"))

                for (i in 0 until types.length()){
                   list.add(types.getJSONObject(i).getJSONObject("type").getString("name"))
                }

                tvType1.text = list.get(0)
                if(list.size ==2){
                    tvType2.text = list.get(1)
                }else{
                    tvType2.text = ""
                }
                //result.getDouble("weight")
                //result.getDouble("height")
                val weight = result.getDouble("weight")
                val height = result.getDouble("height")

                tvWeight.text = weight.toString()
                tvHeight.text = height.toString()


            }, { error ->
                Log.d("error", error.toString())
            }
        ) {}
        reqQueue.add(request)


    }

}