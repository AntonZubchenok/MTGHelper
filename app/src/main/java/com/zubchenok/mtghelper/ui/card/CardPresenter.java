package com.zubchenok.mtghelper.ui.card;

import com.zubchenok.mtghelper.model.entities.Card;
import com.zubchenok.mtghelper.model.entities.CardResponse;
import com.zubchenok.mtghelper.services.interfaces.ICardService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CardPresenter implements CardContract.Presenter {
    private CardContract.View view;
    private ICardService cardService;
    private CompositeDisposable compositeDisposable;

    public CardPresenter(CardContract.View view, ICardService cardService) {
        this.view = view;
        this.cardService = cardService;
        compositeDisposable = new CompositeDisposable();
    }

    public void onFindCardButtonClick(final String cardName) {
        Observable<CardResponse> responseObservable = cardService.getCards(cardName);
        responseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CardResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull CardResponse cardResponse) {
                        if (cardResponse.getCards() != null) {
                            List<Card> cards = cardResponse.getCards();
                            Card card = cards.get(0);
                            view.showCard(card.getName(), card.getImageUrl());
                        } else {
                            view.showToast("Error");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showToast("Error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
    }
}
