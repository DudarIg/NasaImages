package ru.dudar_ig.nasaimages.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("planetary/apod")
    fun loadImage(@Query("api_key") apiKey: String,
                  @Query("date") data: String ): Call<NasaImage>
}