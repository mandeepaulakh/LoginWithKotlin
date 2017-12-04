package com.dupleit.demo.mapproject.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserShow {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("subject_show")
    @Expose
    var subjectShow: String? = null
    @SerializedName("video_show")
    @Expose
    var videoShow: String? = null
    @SerializedName("performance_show")
    @Expose
    var performanceShow: String? = null
    @SerializedName("quiz_show")
    @Expose
    var quizShow: String? = null
    @SerializedName("allvideo_show")
    @Expose
    var allvideoShow: String? = null
    @SerializedName("sub_pos")
    @Expose
    var subPos: String? = null
    @SerializedName("video_pos")
    @Expose
    var videoPos: String? = null
    @SerializedName("videoall_pos")
    @Expose
    var videoallPos: String? = null
    @SerializedName("per_pos")
    @Expose
    var perPos: String? = null
    @SerializedName("quiz_pos")
    @Expose
    var quizPos: String? = null

}
