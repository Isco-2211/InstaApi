package com.example.instagramapi.retrofit

import com.example.instagramapi.model.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiInterface {

    @Headers("x-rapidapi-key:94c5ea1449mshd0e347ca924dcaap140765jsn920003b4b494")
    @GET("{username}/info")
    fun getClasses(@Path("username") userName: String) : Call<UserData>
}