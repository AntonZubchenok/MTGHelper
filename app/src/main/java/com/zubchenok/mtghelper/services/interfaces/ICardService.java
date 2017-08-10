package com.zubchenok.mtghelper.services.interfaces;

import com.zubchenok.mtghelper.model.entities.CardResponse;

import io.reactivex.Single;

public interface ICardService {

    Single<CardResponse> getCards(String cardName);
}
