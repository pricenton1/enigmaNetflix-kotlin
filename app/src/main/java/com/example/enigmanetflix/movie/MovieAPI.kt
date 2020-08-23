package com.example.enigmanetflix.movie

import com.example.enigmanetflix.wrapper.ResponseData
import com.example.enigmanetflix.wrapper.ResponseDataList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieAPI {

    @GET("movies")
    fun getAllmovie():Call<ResponseData>

    @GET("movies/{id}")
    fun getMovieByID(@Path("id")id:String): Call<ResponseData>

    @POST("warehouses/add")
    fun createMovie(@Body movie: Movie): Call<ResponseData>

}