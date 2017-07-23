package com.zubchenok.mtghelper.network;

import com.zubchenok.mtghelper.model.Set;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("sets/{setCode}")
    Call<Set> getSet(@Path("setCode") String setCode);
}
