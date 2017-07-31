package com.zubchenok.mtghelper.network.requests;

import com.zubchenok.mtghelper.model.CardResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetCardRequest {

    @GET("cards")
    Call<CardResponse> getCardsByName(@Query("name") String cardName);
}
