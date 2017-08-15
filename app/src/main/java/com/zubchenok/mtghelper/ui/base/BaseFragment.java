package com.zubchenok.mtghelper.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zubchenok.mtghelper.App;
import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.model.dto.Card;
import com.zubchenok.mtghelper.ui.carddetails.CardDetailsFragment;
import com.zubchenok.mtghelper.ui.cardlist.CardListFragment;
import com.zubchenok.mtghelper.util.ActivityUtils;
import com.zubchenok.mtghelper.util.Const;

import java.util.ArrayList;

import javax.inject.Inject;

public abstract class BaseFragment extends Fragment implements BaseView<BasePresenter> {

    @Inject
    ActivityUtils activityUtils;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showToast(@StringRes int stringId) {
        String message = getString(stringId);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void navigateToCardListFragment(ArrayList<Card> cards) {
        Fragment fragment = CardListFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Const.Extra.CARDS, cards);
        fragment.setArguments(bundle);

        activityUtils.addFragmentToActivity(getFragmentManager(), fragment, R.id.cont_main, CardListFragment.TAG);
    }

    protected void navigateToCardDetailsFragment(Card card) {
        Fragment fragment = getFragmentManager().findFragmentByTag(CardDetailsFragment.TAG);
        if (fragment == null) {
            fragment = CardDetailsFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Const.Extra.CARD, card);
            fragment.setArguments(bundle);
        }

        activityUtils.addFragmentToActivity(getFragmentManager(), fragment, R.id.cont_main, CardDetailsFragment.TAG);
    }
}
