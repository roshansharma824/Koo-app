package com.example.kooapp.repository

import com.example.kooapp.pojo.DataList
import retrofit2.http.GET

interface MainHttpInterface {
    @GET("v1/posts")
    suspend fun getDataList(): DataList
}