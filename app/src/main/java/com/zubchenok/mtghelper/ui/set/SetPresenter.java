package com.zubchenok.mtghelper.ui.set;

import com.zubchenok.mtghelper.model.entities.SetResponse;
import com.zubchenok.mtghelper.network.requests.RequestManager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SetPresenter implements SetContract.Presenter {

    SetContract.View view;
    RequestManager requestManager = RequestManager.getInstance();

    public SetPresenter(SetContract.View view) {
        this.view = view;
    }

    public void onFindSetButtonClick(String setCode) {
        Observable<SetResponse> setObservable = requestManager.getSet(setCode);
        setObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SetResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        //ignore
                    }

                    @Override
                    public void onNext(@NonNull SetResponse setResponse) {
                        String setName = setResponse.getSet().getName();
                        view.showSet(setName);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.showToast("Error");
                    }

                    @Override
                    public void onComplete() {
                        //ignore
                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
