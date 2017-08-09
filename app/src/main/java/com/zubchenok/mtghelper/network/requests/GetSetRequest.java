package com.zubchenok.mtghelper.network.requests;

import com.zubchenok.mtghelper.model.entities.SetResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetSetRequest {

    @GET("sets/{setCode}")
    Observable<SetResponse> getSet(@Path("setCode") String setCode);
}
