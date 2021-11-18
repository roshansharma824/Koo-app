package com.example.kooapp.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kooapp.pojo.Resource
import com.example.kooapp.repository.MainRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel
@ViewModelInject
constructor(private val mainRepository: MainRepository) : ViewModel() {

    fun getDataList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = mainRepository.getDataList()
                )
            )

        } catch (exception: Exception) {
            emit(Resource.error(exception.message ?: "Error Occurred!", data = null))
        }
    }


}
