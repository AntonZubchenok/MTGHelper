package com.zubchenok.mtghelper.ui.set;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.ui.base.BaseFragment;
import com.zubchenok.mtghelper.ui.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetFragment extends BaseFragment implements SetContract.View {

    private SetContract.Presenter presenter;

    @BindView(R.id.edt_set)
    EditText editText;
    @BindView(R.id.txt_set)
    TextView textView;

    public SetFragment() {
        // Required empty public constructor
    }

    public static SetFragment newInstance() {
        return new SetFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //фрагмент не пересоздаётся при смене конфигурации (перевороте)
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_set, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (presenter == null) {
            presenter = new SetPresenter(this);
        }
        presenter.subscribe();
    }

    @Override
    public void onDestroy() {
        presenter.unsubscribe();
        super.onDestroy();
    }

    @Override
    public void showSet(String setName) {
        textView.setText(setName);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (SetContract.Presenter) presenter;
    }

    @OnClick(R.id.btn_find_set)
    public void onFindSetButtonClick() {
        presenter.onFindSetButtonClick(editText.getText().toString());
    }

}

