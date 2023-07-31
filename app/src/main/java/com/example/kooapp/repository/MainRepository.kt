package com.example.kooapp.repository

import androidx.lifecycle.LiveData
import com.example.kooapp.pojo.PostItem



interface MainRepository {
    suspend fun getDataList(): List<PostItem>

    suspend fun getAllPosts(): List<PostItem>


}