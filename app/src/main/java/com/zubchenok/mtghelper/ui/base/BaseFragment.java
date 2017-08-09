package com.zubchenok.mtghelper.ui.base;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment implements BaseView<BasePresenter> {

    @Override
    public void showToast(@StringRes int stringId) {
        String message = getString(stringId);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
