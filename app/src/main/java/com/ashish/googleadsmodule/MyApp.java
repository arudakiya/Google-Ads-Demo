package com.ashish.googleadsmodule;


import android.app.Application;

import com.ashish.googleads.Ads;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Ads.setAdsUnits(
                getApplicationContext(),
                "ca-app-pub-3940256099942544/6300978111",
                "ca-app-pub-3940256099942544/1033173712",
                "ca-app-pub-3940256099942544/1044960115",
                "ca-app-pub-3940256099942544/9257395921",
                "ca-app-pub-3940256099942544/5224354917");
    }
}
