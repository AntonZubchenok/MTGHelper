package com.zubchenok.mtghelper.ui.set;

import com.facebook.stetho.server.http.HttpStatus;
import com.zubchenok.mtghelper.model.Set;
import com.zubchenok.mtghelper.model.SetResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;
import com.zubchenok.mtghelper.network.requests.GetSetRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPresenter {

    ISetView view;

    public SetPresenter(ISetView view) {
        this.view = view;
    }

    public void loadSet(final String setCode) {
        GetSetRequest request = RetrofitClient.getRetrofit().create(GetSetRequest.class);
        request.getSet(setCode).enqueue(new Callback<SetResponse>() {
            @Override
            public void onResponse(Call<SetResponse> call, Response<SetResponse> response) {
                if (response.code() == HttpStatus.HTTP_OK) {
                    SetResponse setResponse = response.body();
                    Set set = setResponse.getSet();
                    view.showSet(set.getName());
                } else {
                    view.showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<SetResponse> call, Throwable t) {
                view.showErrorMessage();
            }
        });
    }
}
