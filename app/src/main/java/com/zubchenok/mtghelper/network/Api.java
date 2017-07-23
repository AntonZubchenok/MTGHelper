package com.zubchenok.mtghelper.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Api instance = null;
    public static final String BASE_URL = "https://api.magicthegathering.io/v1/";
    private ApiClient apiClient;


    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }
        return instance;
    }

    private Api() {
        apiClient = buildClient();
    }


    public static ApiClient buildClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);

        Retrofit retrofit = retrofitBuilder
                .client(httpClient.build())
                .build();
        return retrofit.create(ApiClient.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
