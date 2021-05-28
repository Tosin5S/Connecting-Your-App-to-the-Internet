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

    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var mainAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        getAllData()
    }

    fun getAllData() {
        val recyclerView: RecyclerView = findViewById(R.id.rickAndMortyRv)
        apiService.getAllData().enqueue(object: Callback<Property?>{
            override fun onResponse(
                    call: Call<Property?>,
                    response:Response<Property?>
            ){
                if(response.isSuccessful){
                    recyclerView.apply{
                        val data: List<Result?>? = response.body()!!.list
                        mainAdapter = MainAdapter(context,data)
                        layoutManager = manager
                        recyclerView.mainAdapter = mainAdapter

                    }

                }
            }

            override fun onFailure(call: Call<Property?>, t: Throwable){
                t.printStackTrace()
            }
        })
    }
}
