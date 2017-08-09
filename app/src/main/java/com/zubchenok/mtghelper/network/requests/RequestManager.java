package com.zubchenok.mtghelper.network.requests;

import com.zubchenok.mtghelper.model.entities.SetResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;

import io.reactivex.Observable;

public class RequestManager {

    private static volatile RequestManager instance;

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }

    public Observable<SetResponse> getSet(String setCode) {
        GetSetRequest request = RetrofitClient.getRetrofit().create(GetSetRequest.class);
        return request.getSet(setCode);

    }
}
