package com.zubchenok.mtghelper.ui.card;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zubchenok.mtghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CardFragment extends Fragment implements ICardView {

    @BindView(R.id.edt_card)
    EditText editText;
    @BindView(R.id.txt_card)
    TextView textView;
    @BindView(R.id.imv_card)
    ImageView imageView;

    CardPresenter presenter = new CardPresenter(this);

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment getInstance() {
        return new CardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void showCard(String cardName, String imageUrl) {
        textView.setText(cardName);
        Glide.with(getContext()).load(imageUrl).into(imageView);
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_load_card)
    public void onFindButtonClicked() {
        presenter.loadCard(editText.getText().toString());
    }
}
