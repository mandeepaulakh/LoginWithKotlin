package com.dupleit.demo.mapproject.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserUImodel {

    @SerializedName("status")
    @Expose
    var status: Boolean? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("userData")
    @Expose
    var userData: UserData? = null

}
