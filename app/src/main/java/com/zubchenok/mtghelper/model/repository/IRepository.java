package com.zubchenok.mtghelper.model.repository;

import com.zubchenok.mtghelper.model.entities.CardResponse;

import io.reactivex.Observable;

public interface IRepository {

    Observable<CardResponse> getCards(String cardName);
}
