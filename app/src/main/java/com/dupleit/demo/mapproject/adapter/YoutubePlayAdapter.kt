package com.dupleit.demo.mapproject.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dupleit.demo.mapproject.HelperClasses.Config
import com.dupleit.demo.mapproject.Model.VideosingleAll
import com.dupleit.demo.mapproject.R
import com.dupleit.demo.mapproject.YoutubePlayer
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubeThumbnailLoader
import com.google.android.youtube.player.YouTubeThumbnailView

/**
 * Created by mandeep on 3/11/17.
 */

class YoutubePlayAdapter(internal var ctx: Context, //these ids are the unique id for each video
        // String[] VideoID = {"P3mAtvs5Elc", "nCgQDjiotG0", "P3mAtvs5Elc"};
                         private val playlists: List<VideosingleAll>) : RecyclerView.Adapter<YoutubePlayAdapter.VideoInfoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoInfoHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.youtube_card, parent, false)
        return VideoInfoHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoInfoHolder, position: Int) {


        val onThumbnailLoadedListener = object : YouTubeThumbnailLoader.OnThumbnailLoadedListener {
            override fun onThumbnailError(youTubeThumbnailView: YouTubeThumbnailView, errorReason: YouTubeThumbnailLoader.ErrorReason) {

            }

            override fun onThumbnailLoaded(youTubeThumbnailView: YouTubeThumbnailView, s: String) {
                youTubeThumbnailView.visibility = View.VISIBLE
                holder.relativeLayoutOverYouTubeThumbnailView.visibility = View.VISIBLE
            }
        }

        holder.youTubeThumbnailView.initialize(Config.DEVELOPER_KEY, object : YouTubeThumbnailView.OnInitializedListener {
            override fun onInitializationSuccess(youTubeThumbnailView: YouTubeThumbnailView, youTubeThumbnailLoader: YouTubeThumbnailLoader) {
                val userObject = playlists[position]
                holder.playButton.tag = position
                youTubeThumbnailLoader.setVideo(userObject.videoPath)
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener)
            }

            override fun onInitializationFailure(youTubeThumbnailView: YouTubeThumbnailView, youTubeInitializationResult: YouTubeInitializationResult) {
                //write something for failure
            }
        })
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    inner class VideoInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var relativeLayoutOverYouTubeThumbnailView: RelativeLayout
        internal var youTubeThumbnailView: YouTubeThumbnailView
        var playButton: ImageView

        init {
            playButton = itemView.findViewById<View>(R.id.btnYoutube_player) as ImageView
            playButton.setOnClickListener(this)
            relativeLayoutOverYouTubeThumbnailView = itemView.findViewById<View>(R.id.relativeLayout_over_youtube_thumbnail) as RelativeLayout
            youTubeThumbnailView = itemView.findViewById<View>(R.id.youtube_thumbnail) as YouTubeThumbnailView
        }

        override fun onClick(v: View) {
            val pos = v.tag as Int
            val videoPath = playlists[pos].videoPath
            val startActivityIntent = Intent(ctx, YoutubePlayer::class.java)
            startActivityIntent.putExtra("videoPath", videoPath)
            startActivityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ctx.startActivity(startActivityIntent)
        }
    }
}

