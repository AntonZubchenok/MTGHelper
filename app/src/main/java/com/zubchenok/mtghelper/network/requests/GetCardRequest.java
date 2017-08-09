package com.zubchenok.mtghelper.network.requests;

import com.zubchenok.mtghelper.model.entities.CardResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetCardRequest {

    @GET("cards")
    Observable<CardResponse> getCardsByName(@Query("name") String cardName);
}
