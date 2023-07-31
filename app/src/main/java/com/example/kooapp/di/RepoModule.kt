package com.example.kooapp.di

import com.example.kooapp.repository.MainHttpInterface
import com.example.kooapp.repository.MainRepository
import com.example.kooapp.repository.MainRepositoryImpl
import com.example.kooapp.repository.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideApiHttpInterface(retrofit: Retrofit): MainHttpInterface {
        return retrofit.create(MainHttpInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideMainRepositoryImpl(mainHttpInterface: MainHttpInterface, postDao: PostDao): MainRepository {
        return MainRepositoryImpl(mainHttpInterface = mainHttpInterface,postDao)
    }
}