package com.zubchenok.mtghelper.model.repository;

import com.zubchenok.mtghelper.model.entities.CardResponse;

import io.reactivex.Single;

public interface IRepository {

    Single<CardResponse> getCards(String cardName);
}
