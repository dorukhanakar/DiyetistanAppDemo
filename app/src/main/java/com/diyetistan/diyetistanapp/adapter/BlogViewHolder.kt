package com.diyetistan.diyetistanapp.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.diyetistan.diyetistanapp.R


class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val cardView: CardView by lazy { itemView.findViewById<CardView>(R.id.adapter_item_blog_cardView) }
    val imgBackground: ImageView by lazy { itemView.findViewById<ImageView>(R.id.adapter_item_blog_imgBackground) }
    val txtSummary: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_item_blog_txtSummary) }
    val txtContent: TextView by lazy { itemView.findViewById<TextView>(R.id.adapter_item_blog_txtContent) }
}