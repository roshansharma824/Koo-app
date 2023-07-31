package com.example.kooapp.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kooapp.pojo.PostItem

@Dao
interface PostDao {

    @Query("SELECT *FROM  POSTITEM")
    suspend fun getAllPosts(): List<PostItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(dish: PostItem)
}