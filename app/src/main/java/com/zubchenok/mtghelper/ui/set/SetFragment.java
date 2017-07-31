package com.zubchenok.mtghelper.ui.set;

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

public class SetFragment extends Fragment implements ISetView {
    SetPresenter presenter;

    public SetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_set, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText editText = (EditText) view.findViewById(R.id.field_set);
        final Button button = (Button) view.findViewById(R.id.btn_load_set);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadSet(editText.getText().toString());
            }
        });

        presenter = new SetPresenter(this);
    }

    @Override
    public void showSet(String setName) {
        TextView textView = (TextView) getView().findViewById(R.id.text_set);
        textView.setText(setName);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }
}

