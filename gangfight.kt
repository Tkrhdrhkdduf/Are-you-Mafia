package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_game_view.*

class gangfight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gangfight)
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        banner.loadAd(adRequest)
        banner.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
        val wrong1=findViewById<Button>(R.id.ganswer1)
        val wrong2=findViewById<Button>(R.id.ganswer2)
        val wrong3=findViewById<Button>(R.id.ganswer3)
        val correct=findViewById<Button>(R.id.ganswer4)
        var res=intent

        var result: String? =res.getStringExtra("result")


        correct.setOnClickListener {
            finish()



        }
        wrong1.setOnClickListener {
            val intent= Intent(this, gameover::class.java)// 클라스 게임뷰 객체
            intent.putExtra("result",result)

            startActivity(intent)/* 활성 */

        }
        wrong2.setOnClickListener {
            val intent= Intent(this, gameover::class.java)// 클라스 게임뷰 객체
            intent.putExtra("result",result)
            startActivity(intent)/* 활성 */

        }
        wrong3.setOnClickListener {
            val intent= Intent(this, gameover::class.java)// 클라스 게임뷰 객체
            intent.putExtra("result",result)
            startActivity(intent)/* 활성 */

        }
    }
}