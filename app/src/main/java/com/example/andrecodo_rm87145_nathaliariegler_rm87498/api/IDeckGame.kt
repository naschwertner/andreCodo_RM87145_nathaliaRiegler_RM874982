package com.example.andrecodo_rm87145_nathaliariegler_rm87498.api


import com.example.andrecodo_rm87145_nathaliariegler_rm87498.model.DeckListModel
import com.example.andrecodo_rm87145_nathaliariegler_rm87498.model.DeckModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDeckGame {
    @GET("new/shuffle")
    fun getDeck(
        @Query("deck_count") deckCount : Int
    ): Call<DeckModel>

    @GET("{deck_id}/draw")
    fun getDeckCards(
        @Path("deck_id") deck_id : String,
        @Query("count") deckCount: Int
    ): Call<DeckListModel>
}