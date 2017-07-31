package com.zubchenok.mtghelper.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.model.CardResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;
import com.zubchenok.mtghelper.network.requests.GetCardRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardFragment extends Fragment {

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

        sendCardRequest(view);
    }

    private void sendCardRequest(final View view) {
        GetCardRequest request = RetrofitClient.getRetrofit().create(GetCardRequest.class);
        request.getCard(386616).enqueue(new Callback<CardResponse>() {
            @Override
            public void onResponse(Call<CardResponse> call, Response<CardResponse> response) {
                CardResponse card = response.body();
                TextView textView = (TextView) view.findViewById(R.id.text_card);
                textView.setText(card.getCard().getName());
            }

            @Override
            public void onFailure(Call<CardResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

