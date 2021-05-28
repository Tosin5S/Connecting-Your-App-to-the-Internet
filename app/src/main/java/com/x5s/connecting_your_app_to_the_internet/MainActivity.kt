package com.x5s.connecting_your_app_to_the_internet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x5s.connecting_your_app_to_the_internet.Api.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var mainAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        getAllData()
    }

    fun getAllData() {
        apiService.getAllData().enqueue(object: Callback<List<Property>>{
            override fun onResponse(
                    call: Call<List<Property>>,
                    response:Response<List<Property>>
            ){
                if(response.isSuccessful){
                    recyclerView = findViewById<RecyclerView>(R.id.rickAndMortyRv).apply{
                        mainAdapter = MainAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = mainAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Property>>, t: Throwable){
                t.printStackTrace()
            }
        })
    }
}
