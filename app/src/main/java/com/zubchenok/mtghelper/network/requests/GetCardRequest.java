package com.zubchenok.mtghelper.network.requests;

import com.zubchenok.mtghelper.model.CardResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetCardRequest {

    @GET("cards/{cardId}")
    Call<CardResponse> getCard(@Path("cardId") int cardId);
}
