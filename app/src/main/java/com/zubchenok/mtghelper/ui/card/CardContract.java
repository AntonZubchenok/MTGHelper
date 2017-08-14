package com.zubchenok.mtghelper.ui.card;

import com.zubchenok.mtghelper.model.dto.Card;
import com.zubchenok.mtghelper.ui.base.BasePresenter;
import com.zubchenok.mtghelper.ui.base.BaseView;

import java.util.ArrayList;

public interface CardContract {

    interface View extends BaseView<BasePresenter> {

        void showCards(ArrayList<Card> cards);

        void showProgressBar();

        void hideProgressBar();

    }


    interface Presenter extends BasePresenter {

        void onFindCardButtonClick(String setCode);

    }
}
