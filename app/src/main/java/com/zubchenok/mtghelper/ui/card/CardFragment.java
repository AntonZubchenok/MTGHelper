package com.zubchenok.mtghelper.ui.card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.injection.CardServiceInjection;
import com.zubchenok.mtghelper.ui.base.BaseFragment;
import com.zubchenok.mtghelper.ui.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CardFragment extends BaseFragment implements CardContract.View {

    public static final String TAG = "CARD_FRAGMENT";

    private CardContract.Presenter presenter;

    @BindView(R.id.edt_card)
    EditText editText;
    @BindView(R.id.txt_card)
    TextView textView;
    @BindView(R.id.imv_card)
    ImageView imageView;

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
        presenter.subscribe();
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void showCard(String cardName, String imageUrl) {
        textView.setText(cardName);
        Glide.with(getContext()).load(imageUrl).into(imageView);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (CardContract.Presenter) presenter;
    }

    @OnClick(R.id.btn_find_card)
    public void onFindCardButtonClick() {
        presenter.onFindCardButtonClick(editText.getText().toString());
    }

}
