package com.dupleit.demo.mapproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.dupleit.demo.mapproject.HelperClasses.Config
import com.dupleit.demo.mapproject.Model.VideoAll
import com.dupleit.demo.mapproject.R
import kotlinx.android.synthetic.main.card_images.view.*
import kotlinx.android.synthetic.main.card_subjects.view.*

class VideoListAdapter(private val playlists: List<VideoAll>) : RecyclerView.Adapter<VideoListAdapter.SearchListViewHolder>() {

    inner class SearchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val image = itemView.propertyImage
        val couse = itemView.title
        val videoTime = itemView.videoTime
        val institute = itemView.ownerName
        val userviews = itemView.ownerType
        val name = itemView.profName


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_images, parent, false)
        return SearchListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        val userObject = playlists[position]

        Glide.with(holder.itemView.context).load(Config.Web_path + userObject.imagePath).into(holder.image)
        holder.couse.text = userObject.course
        holder.videoTime.text = "4 min"
        holder.userviews.text = userObject.views + " Views"
        holder.institute.text = userObject.institute
        holder.name.text = "by Prof. " + userObject.name

    }


    override fun getItemCount(): Int {
        return playlists.size
    }
}
