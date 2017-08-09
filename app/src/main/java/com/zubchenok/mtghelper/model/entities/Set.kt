package com.zubchenok.mtghelper.model.entities

import com.google.gson.annotations.SerializedName

data class Set(
        val code: String,
        val name: String,
        val type: String,
        val border: String,
        val releaseDate: String,
        val magicCardsInfoCode: String,
        val block: String,
        @SerializedName("mkm_id")
        val mkmId: Int,
        @SerializedName("mkm_name")
        val mkmName: String
)