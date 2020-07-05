package com.redditapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.redditapi.models.MainWrapper
import com.redditapi.models.PageData

class SubRedditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_reddit)

        val requestString = intent.getStringExtra("REQUEST")
        val page = buildRequestObject(requestString)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecyclerViewAdapter(page)
    }

    private fun buildRequestObject(req: String?): PageData {
        val gson: Gson = GsonBuilder().create()
        val reqObject = gson.fromJson(req, MainWrapper::class.java)
        return reqObject.data
    }
}