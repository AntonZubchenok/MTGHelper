package com.zubchenok.mtghelper.ui.carddetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zubchenok.mtghelper.R;

public class CardDetailsFragment extends Fragment {

    public static final String TAG = "CARD_DETAILS_FRAGMENT";


    public CardDetailsFragment() {
        // Required empty public constructor
    }

    public static CardDetailsFragment newInstance() {
        return new CardDetailsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_details, container, false);
    }

}
