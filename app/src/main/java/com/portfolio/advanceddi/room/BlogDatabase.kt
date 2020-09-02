package com.portfolio.advanceddi.room

import androidx.room.Database

/**
 * Created by paul on 9/2/2020 at 5:40 PM.
 */
@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class BlogDatabase {

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME : String = "blog_db"
    }
}