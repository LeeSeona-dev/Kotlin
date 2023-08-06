package com.lsa.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.lsa.fragment.vo.BoardDataVO
import org.json.JSONArray


class Fragment3 : Fragment() {

    lateinit var rcBoard :RecyclerView
    lateinit var btnWriteAct : Button
    lateinit var reqQueue: RequestQueue


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_3, container, false)

        rcBoard=view.findViewById(R.id.rcBoard)
        btnWriteAct = view.findViewById(R.id.btnWriteAct)
        reqQueue = Volley.newRequestQueue(requireActivity())
        var data = ArrayList<BoardDataVO>()

        btnWriteAct.setOnClickListener{
            var intent:Intent = Intent(requireActivity(),BoardWriteActivity::class.java)
            startActivity(intent)
        }

       val request = object : StringRequest(
            Request.Method.GET,
            "http://172.30.1.36:8888/board",
            {
                response -> Log.d("response",response.toString())
                var result = JSONArray(response)
                Log.d("jsonarray response", result.toString())
                for(i in 0 until result.length()){
                   var board = Gson().fromJson(result.get(i).toString(), BoardDataVO::class.java)
                    data.add(board)
                }

                var adapter = BoardAdapter(requireContext(),R.layout.board_item,data)
                rcBoard.layoutManager = LinearLayoutManager(requireContext())
                rcBoard.adapter = adapter


            },
            {
                error->Log.d("error", error.toString())
            }
        ){}

        reqQueue.add(request)


        return view

    }


}