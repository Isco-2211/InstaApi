package com.example.instagramapi

import com.example.instagramapi.model.Data

interface NetworkListener {

    fun onSchoolClassesResponse (models: Data)
    fun onSchoolClassesFailure(message: String)

}