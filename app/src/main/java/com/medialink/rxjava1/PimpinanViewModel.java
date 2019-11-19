package com.medialink.rxjava1;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.medialink.rxjava1.model.Pimpinan;
import com.medialink.rxjava1.network.BaseApiService;
import com.medialink.rxjava1.network.RetrofitClient;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PimpinanViewModel extends ViewModel {
    private static final String TAG = "PimpinanViewModel";

    private MutableLiveData<List<Pimpinan>> mutaPimpinan = new MutableLiveData<>();
    private List<Pimpinan> listPimpinan;

    public LiveData<List<Pimpinan>> getPimpinan() {
        return mutaPimpinan;
    }

    public void initPimpinan() {
        BaseApiService apiService = RetrofitClient.getApiService();
        apiService.getPimpinan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Pimpinan>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(List<Pimpinan> pimpinans) {
                        mutaPimpinan.postValue(pimpinans);
                        Log.d(TAG, "onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }
}
