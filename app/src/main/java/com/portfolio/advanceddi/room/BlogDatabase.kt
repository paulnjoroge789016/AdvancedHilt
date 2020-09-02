package com.portfolio.advanceddi.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by paul on 9/2/2020 at 5:40 PM.
 */
@Database(entities = arrayOf(BlogCacheEntity::class), version = 1, exportSchema = false)
abstract class BlogDatabase : RoomDatabase(){

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME : String = "blog_db"


    }
}