package com.zubchenok.mtghelper.model.entities

import android.os.Parcel
import android.os.Parcelable

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
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.createStringArray(),
            source.readString(),
            source.readDouble(),
            source.createStringArray(),
            source.createStringArray(),
            source.readString(),
            source.createStringArray(),
            source.createStringArray(),
            source.createStringArray(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(name)
        writeStringArray(names)
        writeString(manaCost)
        writeDouble(cmc)
        writeStringArray(colors)
        writeStringArray(colorIdentity)
        writeString(type)
        writeStringArray(supertypes)
        writeStringArray(types)
        writeStringArray(subtypes)
        writeString(rarity)
        writeString(text)
        writeString(originalText)
        writeString(flavor)
        writeString(number)
        writeString(power)
        writeString(toughness)
        writeString(loyalty)
        writeInt(multiverseId)
        writeString(set)
        writeString(setName)
        writeString(imageUrl)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Card> = object : Parcelable.Creator<Card> {
            override fun createFromParcel(source: Parcel): Card = Card(source)
            override fun newArray(size: Int): Array<Card?> = arrayOfNulls(size)
        }
    }
}