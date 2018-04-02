package com.diyetistan.diyetistanapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.dto.BlogDTO


class BlogAdapter(private val blogList: ArrayList<BlogDTO>) : RecyclerView.Adapter<BlogViewHolder>(), View.OnClickListener {

    private val options = RequestOptions()

    init {

        with(options) {

            centerCrop()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_blog, parent, false)

        return BlogViewHolder(view)
    }

    override fun getItemCount(): Int = blogList.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {

        val blogDTO = blogList[position]

        Glide.with(holder.imgBackground.context).load(blogDTO.url).apply(options).into(holder.imgBackground)
        holder.txtSummary.text = blogDTO.summary
        holder.txtContent.text = blogDTO.content

        holder.cardView.tag = holder.txtContent
        holder.cardView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.adapter_item_blog_cardView -> {

                clickEventSummary(view)
            }
        }
    }

    private fun clickEventSummary(view: View?) {

        if ((view?.tag as TextView).visibility == View.GONE) {
            (view.tag as TextView).visibility = View.VISIBLE
        } else {
            (view.tag as TextView).visibility = View.GONE
        }
    }
}