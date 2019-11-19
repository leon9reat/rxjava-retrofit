package com.medialink.rxjava1.network;

import com.medialink.rxjava1.model.Pimpinan;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BaseApiService {
    String BASE_URL = "http://192.168.100.35:3000/api/";

    @GET("mas_list_pimpinan")
    Observable<List<Pimpinan>> getPimpinan();
}
