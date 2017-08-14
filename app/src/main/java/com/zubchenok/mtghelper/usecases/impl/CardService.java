package com.zubchenok.mtghelper.usecases.impl;

import com.zubchenok.mtghelper.model.dto.CardResponse;
import com.zubchenok.mtghelper.model.repository.IRepository;
import com.zubchenok.mtghelper.model.repository.Repository;
import com.zubchenok.mtghelper.usecases.interfaces.ICardService;

import io.reactivex.Single;

public class CardService implements ICardService {

    private IRepository repository = new Repository();

    @Override
    public Single<CardResponse> getCards(String cardName) {
        return repository.getCards(cardName);
    }
}
