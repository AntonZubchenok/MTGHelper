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

    public class Set {

        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}