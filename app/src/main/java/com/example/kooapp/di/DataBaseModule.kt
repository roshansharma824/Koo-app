package com.example.kooapp.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kooapp.pojo.PostItem
import com.example.kooapp.repository.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun providePostDb(@ApplicationContext context: Context): PostDatabase {
        return Room.databaseBuilder(
            context, PostDatabase::class.java,
            PostDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePostDAO(postDatabase: PostDatabase): PostDao {
        return postDatabase.postDao()
    }
}


@Database(entities = [PostItem::class], version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
        const val DATABASE_NAME: String = "post_db"
    }
}