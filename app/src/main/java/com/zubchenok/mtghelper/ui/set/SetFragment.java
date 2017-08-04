package com.zubchenok.mtghelper.ui.set;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zubchenok.mtghelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetFragment extends Fragment implements ISetView {

    @BindView(R.id.edt_set)
    EditText editText;
    @BindView(R.id.txt_set)
    TextView textView;

    ISetPresenter presenter = new SetPresenter(this);

    public SetFragment() {
        // Required empty public constructor
    }

    public static SetFragment getInstance() {
        return new SetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_set, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void showSet(String setName) {
        textView.setText(setName);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_find_set)
    public void onFindSetButtonClicked() {
        presenter.onFindSetClicked(editText.getText().toString());
    }
}

