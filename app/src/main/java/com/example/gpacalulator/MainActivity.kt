package com.example.gpacalulator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    val spinnerlist= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lottie:LottieAnimationView=findViewById(R.id.lottieanimation)
        lottie.setAnimation(R.raw.small_plant)
        lottie.playAnimation()
        val img:ImageView=findViewById(R.id.dashboardImg)
        val nextBt:Button=findViewById(R.id.NextBt)

        val spinner:Spinner=findViewById(R.id.spinner)

        spinnerlist.add("5")
        spinnerlist.add("6")

       val spinnerAdapter=ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_list_item_checked,spinnerlist)

        spinner.adapter=spinnerAdapter

        val intent1= Intent(this@MainActivity,FiveSubjects::class.java)
        val intent2=Intent(this@MainActivity,SIXSUBJECTS::class.java)
        nextBt.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                when(spinner.selectedItem.toString()){
                    "5"->{
                       startActivity(intent1)
                    }

                    "6"->{
                        startActivity(intent2)
                    }
                }
            }
        })




    }
}