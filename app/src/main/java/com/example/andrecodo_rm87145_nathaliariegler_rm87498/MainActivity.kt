package com.example.andrecodo_rm87145_nathaliariegler_rm87498

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.api.IDeckGame
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.databinding.ActivityMainBinding
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.model.DeckListModel
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.util.NetworkUtils
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //getDeckCards("new")

        bind.button.setOnClickListener {
            getDeckCards("new")
        }
    }

    private fun getDeckEndpoint(): IDeckGame {
        val retrofitClient = NetworkUtils.retroFitInstance("https://deckofcardsapi.com/api/deck/")
        return retrofitClient.create(IDeckGame :: class.java)
    }

    private fun getDeckCards(deckId: String) {
        val endpoint = getDeckEndpoint()
        val callback = endpoint.getDeckCards(deckId, 1)
        callback.enqueue(object: Callback<DeckListModel> {
            override fun onResponse(
                call: Call<DeckListModel>,
                response: Response<DeckListModel>
            ) {
                bind.txtCard.text = response.body()?.cards?.get(0)?.code
                response.body()?.cards?.get(0)?.image?.let {
                    loadCardImage(it)
                }
            }

            override fun onFailure(call: Call<DeckListModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun loadCardImage(imageUrl: String) {
        Picasso.with(this)
            .load(imageUrl)
            .into(bind.imgCard)
    }
}
