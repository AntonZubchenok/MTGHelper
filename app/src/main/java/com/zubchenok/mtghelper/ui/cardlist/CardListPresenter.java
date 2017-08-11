package com.zubchenok.mtghelper.ui.cardlist;

import com.zubchenok.mtghelper.model.entities.Card;

import java.util.ArrayList;

public class CardListPresenter implements CardListContract.Presenter {

    private CardListContract.View view;

    public CardListPresenter(CardListContract.View view, ArrayList<Card> cards) {
        this.view = view;
        view.setUpAdapterAndView(cards);
    }

    @Override
    public void onCardItemClicked(Card card) {
        view.openCardDetailsActivity(card);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
