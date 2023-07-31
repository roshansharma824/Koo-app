package com.example.kooapp.repository


import androidx.lifecycle.LiveData
import com.example.kooapp.pojo.PostItem



class MainRepositoryImpl(private val mainHttpInterface: MainHttpInterface, private val postDao: PostDao) : MainRepository {
    override suspend fun getDataList(): List<PostItem> {
        return mainHttpInterface.getDataList()
    }

    override suspend fun getAllPosts(): List<PostItem> {
        return postDao.getAllPosts()
    }


}