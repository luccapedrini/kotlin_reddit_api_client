package com.redditapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGotoSubreddit = findViewById<Button>(R.id.button)
        btnGotoSubreddit.setOnClickListener {
            val intent = Intent(this, SubRedditActivity::class.java)
            startActivity(intent)
        }
    }
}