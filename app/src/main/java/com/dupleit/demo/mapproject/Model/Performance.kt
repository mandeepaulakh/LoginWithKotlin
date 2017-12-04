package com.dupleit.demo.mapproject.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Performance(per_id: String?, sub_img: String?, sub_name: String?, status: String?) { @SerializedName("per_id")
    @Expose
    var per_id: String? = null
    @SerializedName("performance")
    @Expose
    var performance: String? = null

}
