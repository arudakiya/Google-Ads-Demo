package com.ashish.googleadsmodule;

import static com.ashish.googleads.Ads.bannerAdLoadGoogle;
import static com.ashish.googleads.Ads.showAppOpenAds;
import static com.ashish.googleads.Ads.showFullScreenAds;
import static com.ashish.googleads.Ads.showGoogleNativeAds;
import static com.ashish.googleads.Ads.showRewordAds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ashish.googleads.Ads;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_Interstitial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFullScreenAds(MainActivity.this,R.layout.dialog_loadingnew, new Ads.OnShowAdCompleteListener() {
                    @Override
                    public void onShowAdComplete() {
                        Toast.makeText(getApplicationContext(), "Interstitials Close", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        findViewById(R.id.btn_Banner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bannerAdLoadGoogle(MainActivity.this, findViewById(R.id.lv_google_banner));
            }
        });
        findViewById(R.id.btn_Native).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGoogleNativeAds(MainActivity.this, findViewById(R.id.google_native_lv));
            }
        });
        findViewById(R.id.btn_Reword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRewordAds(MainActivity.this, new Ads.OnShowRewordCompleteListener() {
                    @Override
                    public void onShowAdComplete(boolean isRewordGet) {
                        if (isRewordGet) {
                            Toast.makeText(getApplicationContext(),"Got Reword Sucessfully",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),"can`t get Reword!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        findViewById(R.id.btn_AppOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAppOpenAds(MainActivity.this, new Ads.OnShowAdCompleteListener() {
                    @Override
                    public void onShowAdComplete() {
                        Toast.makeText(getApplicationContext(), "AppOpen Close", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}