package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class gameover : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameover)
        MobileAds.initialize(this) {}


        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3570058888244095/4511106442"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        val menu=findViewById<Button>(R.id.menu)
        menu.setOnClickListener {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()

            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

        }
        mInterstitialAd.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        }

        var text=findViewById<TextView>(R.id.gameover)
        var res=intent
        text.setText(res.getStringExtra("result"))
    }
}