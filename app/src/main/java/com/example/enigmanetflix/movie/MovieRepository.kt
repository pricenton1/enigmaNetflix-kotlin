package com.example.enigmanetflix.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.enigmanetflix.wrapper.ResponseData
import com.example.enigmanetflix.wrapper.ResponseDataList
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(private val movieAPI: MovieAPI) {

    var movie: MutableLiveData<Movie> = MutableLiveData<Movie>()

    var allMovie: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()

    fun getAllMovie(){
        movieAPI.getAllmovie().enqueue(object :Callback<ResponseData>{
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response?.result)
                val movieObject:List<Movie> = gson.fromJson(stringResponse,Array<Movie>::class.java).toList()
                allMovie.value = movieObject
                println(allMovie.value)
            }

        })
    }

    fun getMovieByID(id:String){
        movieAPI.getMovieByID(id).enqueue(object : Callback<ResponseData> {

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()
                val res = responseData?.result
                val gson = Gson()
                movie.value = gson.fromJson(gson.toJson(res), Movie::class.java)
            }

        })
    }

    fun createMovie(movie:Movie){
        movieAPI.createMovie(movie).enqueue(object :Callback<ResponseData>{
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                println(response.isSuccessful)
            }

        })
    }
}