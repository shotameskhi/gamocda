package com.example.harryportter_01version.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.potterdb.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getHarryPotter01versionApi(): HarryPotter01versionApi{
        return getRetrofitInstance().create(HarryPotter01versionApi::class.java)
    }
}