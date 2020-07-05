package com.redditapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var loading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loading = findViewById<ProgressBar>(R.id.progressBar)
        val btnGotoSubreddit = findViewById<Button>(R.id.button)

        btnGotoSubreddit.setOnClickListener {
            loading.visibility = View.VISIBLE
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
                Looper.prepare()
                Toast.makeText(this@MainActivity, "Erro ao fazer a requisição", Toast.LENGTH_SHORT).show()
                loading.visibility = View.INVISIBLE
            }
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                intent.putExtra("REQUEST",  body)
                startActivity(intent)
                loading.visibility = View.INVISIBLE
            }
        })
    }
}