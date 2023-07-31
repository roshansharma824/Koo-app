package com.example.kooapp.repository


import com.example.kooapp.pojo.PostItem

import retrofit2.http.GET

interface MainHttpInterface {
    @GET("/posts")
    suspend fun getDataList(): List<PostItem>
}