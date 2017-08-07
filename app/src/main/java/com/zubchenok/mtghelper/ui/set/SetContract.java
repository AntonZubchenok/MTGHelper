package com.zubchenok.mtghelper.ui.set;

public interface SetContract {

    interface View {

        void showSet(String setName);

        void showErrorToast();
    }


    interface Presenter {

        void onFindSetButtonClick(String setCode);
    }
}
