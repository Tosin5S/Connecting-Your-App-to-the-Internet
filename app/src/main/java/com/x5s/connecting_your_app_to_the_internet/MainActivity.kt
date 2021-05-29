package com.x5s.connecting_your_app_to_the_internet

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x5s.connecting_your_app_to_the_internet.Api.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var adapter:MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context:Context = this
        val progressBar: ProgressBar = findViewById(R.id.pb)

        apiService.getAllData().enqueue(object : Callback<Property?> {
            override fun onResponse(
                call: Call<Property?>,
                response: Response<Property?>
            ) {
                val res: Property? = response.body()!!
                if (res != null) {
                    getDataList(res.list)
                }
                progressBar.visibility = View.GONE
            }


            override fun onFailure(call: Call<Property?>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

   private fun getDataList(data: List<Result?>?) {
       val recyclerView:RecyclerView = findViewById(R.id.rickAndMortyRv)
       adapter = MainAdapter(this,data)
       val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
       recyclerView.layoutManager = layoutManager
       recyclerView.adapter = adapter
     }
    }
