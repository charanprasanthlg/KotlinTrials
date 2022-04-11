package com.example.kotlintrials.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintrials.R


class TikTokAdapter(var videos: List<String>) : RecyclerView.Adapter<TikTokAdapter.VideoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tiktok_ui, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        var liked = false
        var commented = false

        holder.setVideoData(videos[position])

        holder.likeText.setText("200")
        holder.commentText.setText("107")

        holder.likeBtn.setOnClickListener {
            if(liked){
                holder.likeBtn.setImageResource(R.drawable.ic_like)
                holder.likeText.text = "200"
            }else {
                holder.likeBtn.setImageResource(R.drawable.ic_like_true)
                holder.likeText.text = "201"
            }
            liked = !liked
        }
        holder.commentBtn.setOnClickListener {
            if(commented){
                holder.commentBtn.setImageResource(R.drawable.ic_comment)
                holder.commentText.text = "108"
            }else {
                holder.commentBtn.setImageResource(R.drawable.ic_comment_true)
                holder.commentText.text = "109"
            }
            commented = !commented
        }
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var videoView: VideoView = itemView.findViewById(R.id.videoView)

        var likeBtn : ImageView = itemView.findViewById(R.id.likeBtn)
        var likeText : TextView = itemView.findViewById(R.id.likeText)

        var commentBtn : ImageView = itemView.findViewById(R.id.commentBtn)
        var commentText : TextView = itemView.findViewById(R.id.commentText)

        var progressBar : ProgressBar = itemView.findViewById(R.id.progressBar)

        fun setVideoData(videoURL: String) {
            videoView.setVideoPath(videoURL)
            videoView.setOnPreparedListener { mediaPlayer ->
                progressBar.visibility = View.GONE
                mediaPlayer.start()
                val videoRatio = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()
                val screenRatio = videoView.width / videoView.height
                    .toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    videoView.scaleX = scale
                } else {
                    videoView.scaleY = 1f / scale
                }
            }
            videoView.setOnCompletionListener { mediaPlayer -> mediaPlayer.start() }
        }
    }
}