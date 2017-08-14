package com.zubchenok.mtghelper.ui.card;

import com.zubchenok.mtghelper.model.dto.Card;
import com.zubchenok.mtghelper.model.dto.CardResponse;
import com.zubchenok.mtghelper.usecases.interfaces.ICardService;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CardPresenter implements CardContract.Presenter {

    private CardContract.View view;
    private ICardService cardService;
    //на всякий случай
    private CompositeDisposable compositeDisposable;

    public CardPresenter(CardContract.View view, ICardService cardService) {
        this.view = view;
        this.cardService = cardService;
        compositeDisposable = new CompositeDisposable();
    }

    public void onFindCardButtonClick(final String cardName) {
        //TODO реализовать другие проверки
        if (cardName.trim().isEmpty()) {
            view.showToast("Enter card name");
        } else {
            view.showProgressBar();
            compositeDisposable.add(
                    cardService.getCards(cardName)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableSingleObserver<CardResponse>() {

                                @Override
                                public void onSuccess(@NonNull CardResponse cardResponse) {
                                    if (cardResponse.getCards() != null) {
                                        ArrayList<Card> cards = cardResponse.getCards();
                                        view.hideProgressBar();
                                        view.showCards(cards);
                                    } else {
                                        view.showToast("Error");
                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {
                                    view.showToast("Error");
                                }
                            })
            );
        }
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }
}
