package com.zubchenok.mtghelper.ui.card;

public interface CardContract {

    interface View {
        void showCard(String cardName, String imageUrl);

        void showErrorToast();
    }


    interface Presenter {
        void onFindCardButtonClick(String setCode);
    }
}
