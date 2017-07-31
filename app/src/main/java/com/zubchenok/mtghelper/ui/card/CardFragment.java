package com.zubchenok.mtghelper.ui.card;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zubchenok.mtghelper.R;

public class CardFragment extends Fragment implements ICardView {

    CardPresenter presenter;

    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText editText = (EditText) view.findViewById(R.id.field_card);
        final Button button = (Button) view.findViewById(R.id.btn_load_card);

        presenter = new CardPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadCard(editText.getText().toString());
            }
        });
    }


    @Override
    public void showCard(String cardName) {
        TextView textView = (TextView) getView().findViewById(R.id.text_card);
        textView.setText(cardName);
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }
}

