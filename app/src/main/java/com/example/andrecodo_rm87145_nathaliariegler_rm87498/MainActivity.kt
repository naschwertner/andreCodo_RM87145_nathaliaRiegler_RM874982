package com.example.andrecodo_rm87145_nathaliariegler_rm87498

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.util.NetworkUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getCurrencies(){
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://cdn.jsdelivr.net/")
        val endpoint = retrofitClient.create(Endpoint::class.java)
    }
}