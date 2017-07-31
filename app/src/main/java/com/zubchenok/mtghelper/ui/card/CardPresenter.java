package com.zubchenok.mtghelper.ui.card;

import com.facebook.stetho.server.http.HttpStatus;
import com.zubchenok.mtghelper.model.Card;
import com.zubchenok.mtghelper.model.CardResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;
import com.zubchenok.mtghelper.network.requests.GetCardRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardPresenter {
    ICardView view;

    public CardPresenter(ICardView view) {
        this.view = view;
    }

    public void loadCard(final String cardName) {
        GetCardRequest request = RetrofitClient.getRetrofit().create(GetCardRequest.class);
        request.getCard(Integer.valueOf(cardName)).enqueue(new Callback<CardResponse>() {
            @Override
            public void onResponse(Call<CardResponse> call, Response<CardResponse> response) {
                if (response.code() == HttpStatus.HTTP_OK) {
                    CardResponse cardResponse = response.body();
                    Card card = cardResponse.getCard();
                    view.showCard(card.getName());
                } else {
                    view.showErrorToast();
                }
            }

            @Override
            public void onFailure(Call<CardResponse> call, Throwable t) {
                view.showErrorToast();
            }
        });
    }
}
