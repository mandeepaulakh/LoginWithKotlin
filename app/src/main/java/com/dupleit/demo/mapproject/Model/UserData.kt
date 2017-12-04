package com.dupleit.demo.mapproject.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserData {

    @SerializedName("userShow")
    @Expose
    var userShow: UserShow? = null
    @SerializedName("performance")
    @Expose
    var performance: List<Performance>? = null
    @SerializedName("subject")
    @Expose
    var subject: List<Subject>? = null
    @SerializedName("VideoAll")
    @Expose
    var videoAll: List<VideoAll>? = null
    @SerializedName("VideosingleAll")
    @Expose
    var videosingleAll: List<VideosingleAll>? = null
    @SerializedName("quiz_show")
    @Expose
    var quizShow: List<QuizShow>? = null

}
