package com.zubchenok.mtghelper.services.interfaces;

import com.zubchenok.mtghelper.model.entities.CardResponse;

import io.reactivex.Observable;

public interface ICardService {

    Observable<CardResponse> getCards(String cardName);
}
