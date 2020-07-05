package com.redditapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return 43
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardForRow = layoutInflater.inflate(R.layout.post_view, parent, false)
        return CustomViewHolder(cardForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //holder.itemView.post_title.text = "123"
    }
}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}