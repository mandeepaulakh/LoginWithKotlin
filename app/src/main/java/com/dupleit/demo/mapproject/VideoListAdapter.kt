package com.dupleit.demo.mapproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

import com.dupleit.demo.mapproject.HelperClasses.Utils
import com.dupleit.demo.mapproject.Model.VideoAll

class VideoListAdapter(private val playlists: List<VideoAll>) : RecyclerView.Adapter<VideoListAdapter.SearchListViewHolder>() {

    inner class SearchListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var image: ImageView
        internal var couse: TextView
        internal var name: TextView
        internal var institute: TextView
        internal var userviews: TextView
        internal var videoTime: TextView

        init {
            image = itemView.findViewById(R.id.propertyImage)
            couse = itemView.findViewById(R.id.title)
            videoTime = itemView.findViewById(R.id.videoTime)
            institute = itemView.findViewById(R.id.ownerName)
            userviews = itemView.findViewById(R.id.ownerType)
            name = itemView.findViewById(R.id.profName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_images, parent, false)
        return SearchListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchListViewHolder, position: Int) {
        val userObject = playlists[position]

        Glide.with(holder.itemView.context).load(Utils.webUrl + userObject.imagePath).into(holder.image)
        holder.couse.setText(userObject.course)
        holder.videoTime.text = "4 min"
        holder.userviews.setText(userObject.views + " Views")
        holder.institute.setText(userObject.institute)
        holder.name.text = "by Prof. " + userObject.name

    }


    override fun getItemCount(): Int {
        return playlists.size
    }
}
