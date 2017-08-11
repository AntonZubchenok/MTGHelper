package com.zubchenok.mtghelper.ui.cardlist;

import com.zubchenok.mtghelper.model.entities.Card;
import com.zubchenok.mtghelper.ui.base.BasePresenter;
import com.zubchenok.mtghelper.ui.base.BaseView;

import java.util.ArrayList;

public interface CardListContract {

    interface View extends BaseView<BasePresenter> {

        void openCardDetailsActivity(Card card);

        void setUpAdapterAndView(ArrayList<Card> cards);
    }


    interface Presenter extends BasePresenter {

        void onCardItemClicked(Card card);

    }
}
