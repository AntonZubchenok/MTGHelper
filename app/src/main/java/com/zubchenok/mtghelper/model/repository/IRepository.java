package com.zubchenok.mtghelper.model.repository;

import com.zubchenok.mtghelper.model.dto.CardResponse;

import io.reactivex.Single;

public interface IRepository {

    Single<CardResponse> getCards(String cardName);
}
