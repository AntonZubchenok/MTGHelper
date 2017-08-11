package com.zubchenok.mtghelper.ui.base;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.model.entities.Card;
import com.zubchenok.mtghelper.ui.carddetails.CardDetailsFragment;
import com.zubchenok.mtghelper.ui.cardlist.CardListFragment;
import com.zubchenok.mtghelper.util.ActivityUtils;
import com.zubchenok.mtghelper.util.Const;

import java.util.ArrayList;

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

    protected void navigateToCardListFragment(ArrayList<Card> cards) {
        Fragment fragment = getFragmentManager().findFragmentByTag(CardListFragment.TAG);
        if (fragment == null) {
            fragment = CardListFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(Const.Extra.CARDS, cards);
            fragment.setArguments(bundle);
        }

        ActivityUtils.addFragmentToActivity(getFragmentManager(), fragment, R.id.cont_main, CardListFragment.TAG);
    }

    protected void navigateToCardDetailsFragment(Card card) {
        Fragment fragment = getFragmentManager().findFragmentByTag(CardDetailsFragment.TAG);
        if (fragment == null) {
            fragment = CardDetailsFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putParcelable(Const.Extra.CARD, card);
            fragment.setArguments(bundle);
        }

        ActivityUtils.addFragmentToActivity(getFragmentManager(), fragment, R.id.cont_main, CardDetailsFragment.TAG);
    }
}
