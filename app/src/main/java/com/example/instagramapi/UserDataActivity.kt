package com.example.instagramapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.instagramapi.model.Data
import com.example.instagramapi.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_user_data.*

class UserDataActivity : AppCompatActivity(), NetworkListener {

    private lateinit var networkHelper: NetworkHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)
        val userName = intent.getStringExtra("username")!!
        networkHelper = NetworkHelper(ApiClient.getClient())
        setData(userName)
    }

    private fun setData(userName: String) {
        networkHelper.getUsersData(this, userName)
    }

    override fun onSchoolClassesResponse(models: Data) {
        tvResUserName.text = models.full_name
        tvResFollowers.text = models.figures.followers.toString()
        tvResFollows.text = models.figures.followings.toString()
        tvResPosts.text = models.figures.posts.toString()
        tvResBiography.text = models.biography

        Glide
            .with(this)
            .load(models.profile_picture.normal)
            .centerCrop()
            .into(ivAvatar)

    }

    override fun onSchoolClassesFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}