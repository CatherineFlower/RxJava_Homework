package com.theost.rxapp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Api {

    private static final int API_OBJECTS_COUNT = 100000;

    public static Observable<List<ApiObject>> getData() {
        return Observable.fromCallable(() -> {
            List<ApiObject> objects = new ArrayList<>();
            for (int i = 0; i < API_OBJECTS_COUNT; i++) objects.add(new ApiObject(i));
            return objects;
        }).delay(2000, TimeUnit.MILLISECONDS);
    }

}
