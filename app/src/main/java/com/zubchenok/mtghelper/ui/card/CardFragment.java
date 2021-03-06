package com.zubchenok.mtghelper.ui.card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.injection.CardServiceInjection;
import com.zubchenok.mtghelper.model.dto.Card;
import com.zubchenok.mtghelper.ui.base.BaseActivity;
import com.zubchenok.mtghelper.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CardFragment extends BaseFragment implements CardContract.View {

    public static final String TAG = "CARD_FRAGMENT";
    private CardContract.Presenter presenter;

    @BindView(R.id.edt_name)
    EditText editText;

//    @BindView(R.id.prb_card_fragment)
//    ProgressBar progressBar;

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance() {
        return new CardFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //фрагмент не пересоздаётся при смене конфигурации (перевороте)
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (presenter == null) {
            presenter = new CardPresenter(this, CardServiceInjection.provideCardService());
        }
        //на всякий случай
        presenter.subscribe();
    }

    @Override
    public void onDestroy() {
        //на всякий случай
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void showCards(ArrayList<Card> cards) {
        navigateToCardListFragment(cards);
    }

    @Override
    public void showProgressBar() {
//        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
//        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideKeyboard() {
        ((BaseActivity) getActivity()).hideKeyboard();
    }

    @OnClick(R.id.btn_find_card)
    public void onFindCardButtonClick() {
        presenter.onFindCardButtonClick(editText.getText().toString());
    }
}
