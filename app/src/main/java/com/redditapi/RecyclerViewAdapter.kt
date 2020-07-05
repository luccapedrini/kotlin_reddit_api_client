package com.redditapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.redditapi.models.PageData
import kotlinx.android.synthetic.main.post_view.view.*

class RecyclerViewAdapter(private val page: PageData): RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return page.children.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardForRow = layoutInflater.inflate(R.layout.post_view, parent, false)
        return CustomViewHolder(cardForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val post = page.children[position].data

        holder.itemView.post_title.text = post.title
        val authorString = "Postado por u/" + post.author
        holder.itemView.post_author.text = authorString
    }
}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}