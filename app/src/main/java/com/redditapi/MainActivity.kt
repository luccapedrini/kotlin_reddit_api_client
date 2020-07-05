package com.redditapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.redditapi.models.MainWrapper
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGotoSubreddit = findViewById<Button>(R.id.button)
        btnGotoSubreddit.setOnClickListener {
            val intent = Intent(this, SubRedditActivity::class.java)
            fetchData(intent)
        }
    }

    private fun fetchData(intent: Intent){
        val url = "https://www.reddit.com/r/androiddev.json?raw_json=1"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                intent.putExtra("REQUEST",  body)
                startActivity(intent)
            }
        })
    }
}