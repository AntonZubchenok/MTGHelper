package com.zubchenok.mtghelper.ui.cardlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zubchenok.mtghelper.R;

public class CardListFragment extends Fragment {
    public static final String TAG = "CARD_LIST_FRAGMENT";


    public CardListFragment() {
        // Required empty public constructor
    }

    public static CardListFragment newInstance() {
        return new CardListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card_list, container, false);
    }

}
