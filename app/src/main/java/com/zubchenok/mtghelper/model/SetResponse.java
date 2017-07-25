package com.zubchenok.mtghelper.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetResponse {

    @SerializedName("set")
    @Expose
    private Set set;

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }
}