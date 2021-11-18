package com.example.kooapp.repository

import com.example.kooapp.pojo.DataList

interface MainRepository {
    suspend fun getDataList(): DataList
}