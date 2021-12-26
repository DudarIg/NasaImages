package ru.dudar_ig.nasaimages.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.dudar_ig.nasaimages.BuildConfig

private const val BASEURL = "https://api.nasa.gov/"

class NasaApiImpl {
    private val api: NasaApi

    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .build()
        api = retrofit.create(NasaApi::class.java)
    }

    fun nasaImage(dat: String): LiveData<NasaImage> {

        val responseLiveData = MutableLiveData<NasaImage>()
        api.loadImage(BuildConfig.NASA_KEY_API, dat).enqueue(object : Callback<NasaImage>{
            override fun onResponse(call: Call<NasaImage>, response: Response<NasaImage>) {
                val jsonImage: NasaImage? = response.body()
                responseLiveData.value = jsonImage!!
            }
            override fun onFailure(call: Call<NasaImage>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return responseLiveData
    }



}