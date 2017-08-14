package com.zubchenok.mtghelper.usecases.interfaces;

import com.zubchenok.mtghelper.model.dto.CardResponse;

import io.reactivex.Single;

public interface ICardService {

    Single<CardResponse> getCards(String cardName);
}
