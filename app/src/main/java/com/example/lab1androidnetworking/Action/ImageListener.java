package com.example.lab1androidnetworking.Action;

import android.graphics.Bitmap;

public interface ImageListener<T> {

    void start();

    void finish(T t);

}
