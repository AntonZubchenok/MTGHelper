package com.zubchenok.mtghelper.model.entities

data class Card(
        val id: String,
        val name: String,
        val names: Array<String>,
        val manaCost: String,
        val cmc: Double,
        val colors: Array<String>,
        val colorIdentity: Array<String>,
        val type: String,
        val supertypes: Array<String>,
        val types: Array<String>,
        val subtypes: Array<String>,
        val rarity: String,
        val text: String,
        val originalText: String,
        val flavor: String,
        val number: String,
        val power: String,
        val toughness: String,
        val loyalty: String,
        val multiverseId: Int,
        val set: String,
        val setName: String,
        val imageUrl: String
)