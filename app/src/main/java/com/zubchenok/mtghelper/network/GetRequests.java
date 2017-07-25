package com.zubchenok.mtghelper.network;

import com.zubchenok.mtghelper.model.SetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetRequests {

    @GET("sets/{setCode}")
    Call<SetResponse> getSetResponse(@Path("setCode") String setCode);
}
