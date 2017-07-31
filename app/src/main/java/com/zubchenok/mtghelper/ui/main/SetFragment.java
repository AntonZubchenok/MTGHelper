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
import com.zubchenok.mtghelper.model.SetResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;
import com.zubchenok.mtghelper.network.requests.GetSetRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetFragment extends Fragment {

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

        sendSetRequest(view);
    }

    private void sendSetRequest(final View view) {
        GetSetRequest request = RetrofitClient.getRetrofit().create(GetSetRequest.class);
        request.getSet("ktk").enqueue(new Callback<SetResponse>() {
            @Override
            public void onResponse(Call<SetResponse> call, Response<SetResponse> response) {
                SetResponse set = response.body();
                TextView textView = (TextView) view.findViewById(R.id.text_set);
                textView.setText(set.getSet().getName());
            }

            @Override
            public void onFailure(Call<SetResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

