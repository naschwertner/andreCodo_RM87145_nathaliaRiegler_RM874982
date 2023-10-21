package com.example.andrecodo_rm87145_nathaliariegler_rm87498.model

data class DeckListModel(
    val cards: List<Card>,
    val deck_id: String,
    val remaining: Int,
    val success: Boolean
)