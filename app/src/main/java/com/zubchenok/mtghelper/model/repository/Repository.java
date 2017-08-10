package com.zubchenok.mtghelper.model.repository;

import com.zubchenok.mtghelper.model.entities.CardResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;
import com.zubchenok.mtghelper.network.requests.GetCardRequest;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class Repository implements IRepository {

    private Retrofit retrofit = RetrofitClient.getRetrofit();

    @Override
    public Single<CardResponse> getCards(String cardName) {
        GetCardRequest request = retrofit.create(GetCardRequest.class);
         return request.getCardsByName(cardName);
    }
}
