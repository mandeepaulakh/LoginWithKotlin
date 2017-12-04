package com.dupleit.demo.kotlintest.Network

/**
 * Created by mandeep on 6/7/17.
 */
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import com.dupleit.demo.mapproject.HelperClasses.Utils

object ApiClient {

    val BASE_URL = Utils.webUrl
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                val gson = GsonBuilder()
                        .setLenient()
                        .create()

                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
            }
            return retrofit
        }
}