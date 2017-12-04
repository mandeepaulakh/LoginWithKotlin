package com.dupleit.demo.mapproject.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Subject(@field:SerializedName("sub_id")
              @field:Expose
              var sub_id: String?, @field:SerializedName("sub_img")
              @field:Expose
              var sub_img: String?, @field:SerializedName("sub_name")
              @field:Expose
              var sub_name: String?, @field:SerializedName("status")
              @field:Expose
              var status: String?)
//data class Subject(val sub_id: String,val sub_img: String,val sub_name: String,val status: String)

