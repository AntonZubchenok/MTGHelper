package com.zubchenok.mtghelper.network.get;

import com.zubchenok.mtghelper.model.SetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetSetRequest {

    @GET("sets/{setCode}")
    Call<SetResponse> getSet(@Path("setCode") String setCode);
}
