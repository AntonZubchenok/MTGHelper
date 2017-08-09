package com.zubchenok.mtghelper.ui.card;

import com.zubchenok.mtghelper.ui.base.BasePresenter;
import com.zubchenok.mtghelper.ui.base.BaseView;

public interface CardContract {

    interface View extends BaseView<BasePresenter> {

        void showCard(String cardName, String imageUrl);

    }

    interface Presenter extends BasePresenter {

        void onFindCardButtonClick(String setCode);

    }
}
