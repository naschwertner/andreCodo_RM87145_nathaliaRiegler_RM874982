package com.example.andrecodo_rm87145_nathaliariegler_rm87498.model

data class CardSearchList(
    val `data`: List<CardData>,
    val has_more: Boolean,
    val `object`: String,
    val total_cards: Int
)