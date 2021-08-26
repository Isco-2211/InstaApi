package com.example.instagramapi

import com.example.instagramapi.model.Data
import com.example.instagramapi.model.UserData
import com.example.instagramapi.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NetworkHelper(private val apiClient: Retrofit) {

    fun getUsersData(listener: NetworkListener, userName: String) {
        val call: Call<UserData> = apiClient.create(ApiInterface::class.java).getClasses(userName)
        call.enqueue(object : Callback<UserData> {
            override fun onResponse(
                call: Call<UserData?>,
                response: Response<UserData?>
            ) {
                listener.onSchoolClassesResponse(response.body()?.data!!)
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                listener.onSchoolClassesFailure(t.localizedMessage!!)
            }
        })
    }
}