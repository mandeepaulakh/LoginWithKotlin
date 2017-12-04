package com.dupleit.demo.kotlintest.Network

import com.dupleit.demo.mapproject.Login.model.LoginModel
import com.dupleit.demo.mapproject.Model.UserUImodel
import com.dupleit.demo.mapproject.SignUp.Model.SignupModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by mandeep on 9/11/17.
 */
interface ApiService {

    @FormUrlEncoded
    @POST("userlogin_request")
    abstract fun loginRequest(@Field("useremail") email: String, @Field("password") password: String): Call<LoginModel>

    @FormUrlEncoded
    @POST("checkUserSignup_request")
    abstract fun signUpRequest(@Field("USER_EMAIL") email: String, @Field("USER_PASSWORD") password: String, @Field("USER_NAME") name: String, @Field("USER_MOBILE") userMobile: String): Call<SignupModel>

    @FormUrlEncoded
    @POST("getUidata")
    abstract fun getUidata(@Field("test") test: String): Call<UserUImodel>
}