package com.example.gpacalulator

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        val holder=Handler(Looper.getMainLooper())

        val intent:Intent=Intent(this@SplashScreen,MainActivity::class.java)

        holder.postDelayed({
            startActivity(intent)
            finish()
        },4000)
    }
}