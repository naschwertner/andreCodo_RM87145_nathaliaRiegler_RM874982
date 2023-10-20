package com.example.andrecodo_rm87145_nathaliariegler_rm87498

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.api.Endpoint
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.util.NetworkUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getCurrencies(){
        val retrofirClient = NetworkUtils.getRetroFitInstance("https://cdn.jsdelivr.net/")
        val endpoint = retrofirClient.create(Endpoint::class.java)

        endpoint.getCurrencies().enqueue(object : retrofit2.Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var data = mutableListOf<String>()

                response.body()?.keySet()?.iterator()?.forEach {
                    data.add(it)
                }
                print
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("Não foi")
            }

        })

        }
    }
}