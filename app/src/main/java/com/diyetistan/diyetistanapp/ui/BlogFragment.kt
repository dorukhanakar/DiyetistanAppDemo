package com.diyetistan.diyetistanapp.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diyetistan.diyetistanapp.R
import com.diyetistan.diyetistanapp.adapter.BlogAdapter
import com.diyetistan.diyetistanapp.dto.BlogDTO
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class BlogFragment : Fragment(), ValueEventListener {

    private val database by lazy { FirebaseDatabase.getInstance() }
    private val databaseReference by lazy { database.reference.child("Blog") }

    private var masterView: View? = null
    private var recyclerView: RecyclerView? = null
    private val blogList = ArrayList<BlogDTO>()

    companion object {
        val TAG: String = BlogFragment::class.java.simpleName
        fun newInstance() = BlogFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.title_blog)

        masterView = inflater.inflate(R.layout.fragment_blog, container, false)
        recyclerView = masterView?.findViewById<RecyclerView>(R.id.fragment_blog_recyBlogList)

        databaseReference.addValueEventListener(this)

        return masterView
    }

    override fun onDataChange(dataSnapshot: DataSnapshot?) {
        blogList.clear()
        dataSnapshot?.children?.forEach { dataItem ->

            val blogDTO = dataItem.getValue(BlogDTO::class.java)
            blogDTO?.let { blogList.add(it) }
        }

        val layoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = layoutManager

        val blogadapter = BlogAdapter(blogList)
        recyclerView?.adapter = blogadapter
    }

    override fun onCancelled(databaseError: DatabaseError?) {

    }
}