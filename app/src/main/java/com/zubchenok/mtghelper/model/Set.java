package com.zubchenok.mtghelper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Set {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("border")
    @Expose
    private String border;

    @SerializedName("mkm_id")
    @Expose
    private int mkmId;

    @SerializedName("mkm_name")
    @Expose
    private String mkmName;

    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;

    @SerializedName("magicCardsInfoCode")
    @Expose
    private String magicCardsInfoCode;

    @SerializedName("block")
    @Expose
    private String block;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public int getMkmId() {
        return mkmId;
    }

    public void setMkmId(int mkmId) {
        this.mkmId = mkmId;
    }

    public String getMkmName() {
        return mkmName;
    }

    public void setMkmName(String mkmName) {
        this.mkmName = mkmName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMagicCardsInfoCode() {
        return magicCardsInfoCode;
    }

    public void setMagicCardsInfoCode(String magicCardsInfoCode) {
        this.magicCardsInfoCode = magicCardsInfoCode;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
