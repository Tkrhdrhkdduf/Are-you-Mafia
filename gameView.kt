package com.example.game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_game_view.*
import kotlin.random.Random

class gameView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_view)
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
        val upy = -90f
        var sum = 0
        var sum1=0
        val lx=-90f
        val rx=90f
        val downy = 90f
        val up = findViewById<Button>(R.id.up)//id 가져옴
        val down=findViewById<Button>(R.id.down)
        val left=findViewById<Button>(R.id.left)
        val right=findViewById<Button>(R.id.right)
        val player = findViewById<ImageView>(R.id.character)
        val score=findViewById<TextView>(R.id.score)
        var point=0

        if (player != null) {
            up?.setOnClickListener {


                sum = (sum + upy).toInt() //sum은위치 위로90만큼 위치에다 더해준다
                player.translationY = sum.toFloat() // 플레이어 위치 반영
                if(sum.equals(-720)&&sum1.equals(0)){// 만약 sum,sum1위치가 반영되면 밑에 실행 폴리스 위치
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, police1::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */

                }
                if(sum.equals(-270)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police2::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-990)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police3::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(-360)&&sum1.equals(270)) or (sum.equals(-270)&&sum1.equals(180))or(sum.equals(-180)&&sum1.equals(360))or(sum.equals(-630)&&sum1.equals(630))
                or(sum.equals(-720)&&sum1.equals(900))or(sum.equals(-810)&&sum1.equals(720))){
                    point+=20
                    score.setText("Score: "+point)

                    val randomize= Random
                    val seen=randomize.nextInt(5)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-20))

                    when(seen){
                        1->intent.setClass(this,fight::class.java)
                        2->intent.setClass(this,fight2::class.java)
                        3->intent.setClass(this,fight3::class.java)
                        4->intent.setClass(this,fight4::class.java)
                        5->intent.setClass(this,fight5::class.java)




                    }

                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(0)&&sum1.equals(720))or(sum.equals(0)&&sum1.equals(900))or(sum.equals(180)&&sum1.equals(630))or(sum.equals(180)&&sum1.equals(900))){
                    point+=30
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(8)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-30))
                    when(seen){
                        1->intent.setClass(this,gangfight::class.java)
                        2->intent.setClass(this,gangfight2::class.java)
                        3->intent.setClass(this,gangfight3::class.java)
                        4->intent.setClass(this,gangfight4::class.java)
                        5->intent.setClass(this,gangfight5::class.java)
                        6->intent.setClass(this,gangfight6::class.java)
                        7->intent.setClass(this,gangfight7::class.java)
                        8->intent.setClass(this,gangfight8::class.java)


                    }
                    startActivity(intent)/* 활성 */

                }

            }
            down?.setOnClickListener {
                sum = (sum + downy).toInt()
                player.translationY = sum.toFloat()
                if(sum.equals(-720)&&sum1.equals(0)){
                    point+=60
                    score.setText("Score: "+point)
                    val intent= Intent(this, police1::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-270)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police2::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-990)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police3::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(-360)&&sum1.equals(270)) or (sum.equals(-270)&&sum1.equals(180))or(sum.equals(-180)&&sum1.equals(360))or(sum.equals(-630)&&sum1.equals(630))
                    or(sum.equals(-720)&&sum1.equals(900))or(sum.equals(-810)&&sum1.equals(720))){
                    point+=20
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(5)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-20))
                    when(seen){
                        1->intent.setClass(this,fight::class.java)
                        2->intent.setClass(this,fight2::class.java)
                        3->intent.setClass(this,fight3::class.java)
                        4->intent.setClass(this,fight4::class.java)
                        5->intent.setClass(this,fight5::class.java)
                    }
                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(0)&&sum1.equals(720))or(sum.equals(0)&&sum1.equals(900))or(sum.equals(180)&&sum1.equals(630))or(sum.equals(180)&&sum1.equals(900))){
                    point+=30
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(8)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-30))
                    when(seen){
                        1->intent.setClass(this,gangfight::class.java)
                        2->intent.setClass(this,gangfight2::class.java)
                        3->intent.setClass(this,gangfight3::class.java)
                        4->intent.setClass(this,gangfight4::class.java)
                        5->intent.setClass(this,gangfight5::class.java)
                        6->intent.setClass(this,gangfight6::class.java)
                        7->intent.setClass(this,gangfight7::class.java)
                        8->intent.setClass(this,gangfight8::class.java)


                    }
                    startActivity(intent)/* 활성 */

                }
            }
            left?.setOnClickListener {
                sum1 = (sum1 + lx).toInt()
                player.translationX = sum1.toFloat()
                if(sum.equals(-720)&&sum1.equals(0)){
                    point+=60
                    score.setText("Score: "+point)
                    val intent= Intent(this, police1::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-270)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police2::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-990)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police3::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(-360)&&sum1.equals(270)) or (sum.equals(-270)&&sum1.equals(180))or(sum.equals(-180)&&sum1.equals(360))or(sum.equals(-630)&&sum1.equals(630))
                    or(sum.equals(-720)&&sum1.equals(900))or(sum.equals(-810)&&sum1.equals(720))){
                    point+=20
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(5)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-20))
                    when(seen){
                        1->intent.setClass(this,fight::class.java)
                        2->intent.setClass(this,fight2::class.java)
                        3->intent.setClass(this,fight3::class.java)
                        4->intent.setClass(this,fight4::class.java)
                        5->intent.setClass(this,fight5::class.java)
                    }
                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(0)&&sum1.equals(720))or(sum.equals(0)&&sum1.equals(900))or(sum.equals(180)&&sum1.equals(630))or(sum.equals(180)&&sum1.equals(900))){
                    point+=30
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(8)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-30))
                    when(seen){
                        1->intent.setClass(this,gangfight::class.java)
                        2->intent.setClass(this,gangfight2::class.java)
                        3->intent.setClass(this,gangfight3::class.java)
                        4->intent.setClass(this,gangfight4::class.java)
                        5->intent.setClass(this,gangfight5::class.java)
                        6->intent.setClass(this,gangfight6::class.java)
                        7->intent.setClass(this,gangfight7::class.java)
                        8->intent.setClass(this,gangfight8::class.java)


                    }
                    startActivity(intent)/* 활성 */

                }
            }
            right?.setOnClickListener {
                sum1 = (sum1 + rx).toInt()
                player.translationX = sum1.toFloat()
                if(sum.equals(-720)&&sum1.equals(0)){
                    point+=60
                    score.setText("Score: "+point)
                    val intent= Intent(this, police1::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-270)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police2::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                if(sum.equals(-990)&&sum1.equals(720)){
                    point+=60
                    score.setText("Score: "+point)//text 에다 점수 올려서 만듬

                    val intent= Intent(this, Police3::class.java)// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-60))//데이터 전송
                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(-360)&&sum1.equals(270)) or (sum.equals(-270)&&sum1.equals(180))or(sum.equals(-180)&&sum1.equals(360))or(sum.equals(-630)&&sum1.equals(630))
                    or(sum.equals(-720)&&sum1.equals(900))or(sum.equals(-810)&&sum1.equals(720))){
                    point+=20
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(5)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-20))
                    when(seen){
                        1->intent.setClass(this,fight::class.java)
                        2->intent.setClass(this,fight2::class.java)
                        3->intent.setClass(this,fight3::class.java)
                        4->intent.setClass(this,fight4::class.java)
                        5->intent.setClass(this,fight5::class.java)
                    }

                    startActivity(intent)/* 활성 */
                }
                else if((sum.equals(0)&&sum1.equals(720))or(sum.equals(0)&&sum1.equals(900))or(sum.equals(180)&&sum1.equals(630))or(sum.equals(180)&&sum1.equals(900))){
                    point+=30
                    score.setText("Score: "+point)
                    val randomize= Random
                    val seen=randomize.nextInt(8)+1;
                    val intent= Intent()// 클라스 게임뷰 객체
                    intent.putExtra("result","Score: "+(point-30))
                    when(seen){
                        1->intent.setClass(this,gangfight::class.java)
                        2->intent.setClass(this,gangfight2::class.java)
                        3->intent.setClass(this,gangfight3::class.java)
                        4->intent.setClass(this,gangfight4::class.java)
                        5->intent.setClass(this,gangfight5::class.java)
                        6->intent.setClass(this,gangfight6::class.java)
                        7->intent.setClass(this,gangfight7::class.java)
                        8->intent.setClass(this,gangfight8::class.java)


                    }
                    startActivity(intent)/* 활성 */

                }
            }


        }



    }




}








