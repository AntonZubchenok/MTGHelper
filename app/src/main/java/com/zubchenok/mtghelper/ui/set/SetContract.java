package com.zubchenok.mtghelper.ui.set;

import com.zubchenok.mtghelper.ui.base.BasePresenter;
import com.zubchenok.mtghelper.ui.base.BaseView;

public interface SetContract {

    interface View extends BaseView<BasePresenter> {

        void showSet(String setName);

    }


    interface Presenter extends BasePresenter {

        void onFindSetButtonClick(String setCode);

    }
}

