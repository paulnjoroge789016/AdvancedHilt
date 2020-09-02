package com.portfolio.advanceddi.di

import android.content.Context
import androidx.room.Room
import com.portfolio.advanceddi.room.BlogDao
import com.portfolio.advanceddi.room.BlogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by paul on 9/2/2020 at 6:04 PM.
 */

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): BlogDatabase{
        return Room.databaseBuilder(context, BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Singleton
    @Provides
    fun provideBlogDao(blogDatabase: BlogDatabase) : BlogDao{
        return blogDatabase.blogDao()
    }
}