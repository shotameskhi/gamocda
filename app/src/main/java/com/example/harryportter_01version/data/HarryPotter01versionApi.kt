package com.example.harryportter_01version.data

import com.example.harryportter_01version.databinding.ActivityBookListBinding
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HarryPotter01versionApi {

//    @GET("books")
//    suspend fun  getBooksList():Response<BooksList>

    @GET("books")
    suspend fun getBooksList(@Query("id") id: String = ""): Response<BooksList>

}