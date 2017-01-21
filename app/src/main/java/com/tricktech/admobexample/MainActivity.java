package com.tricktech.admobexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    public AdView adView;
    public InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView = (AdView) findViewById(R.id.adView);
        adView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ads_unitid));
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showInterstitialAds();
            }
        });

    }

    public void showInterstitialAds(){
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adView != null){
            adView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null){
            adView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView != null){
            adView.destroy();
        }
    }
}
