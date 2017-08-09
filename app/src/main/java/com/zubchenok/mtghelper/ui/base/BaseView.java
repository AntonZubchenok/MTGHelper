package com.zubchenok.mtghelper.ui.base;

import android.support.annotation.StringRes;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

    void showToast(@StringRes int stringId);

    void showToast(String message);

}
