package com.example.kooapp.repository

import com.example.kooapp.pojo.DataList


class MainRepositoryImpl(private val mainHttpInterface: MainHttpInterface) : MainRepository {
    override suspend fun getDataList(): DataList {
        return mainHttpInterface.getDataList()
    }


}