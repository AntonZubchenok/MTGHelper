package com.zubchenok.mtghelper.services.impl;

import com.zubchenok.mtghelper.model.entities.CardResponse;
import com.zubchenok.mtghelper.model.repository.IRepository;
import com.zubchenok.mtghelper.model.repository.Repository;
import com.zubchenok.mtghelper.services.interfaces.ICardService;

import io.reactivex.Single;

public class CardService implements ICardService {

    private IRepository repository = new Repository();

    @Override
    public Single<CardResponse> getCards(String cardName) {
        return repository.getCards(cardName);
    }
}
