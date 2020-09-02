package com.portfolio.advanceddi.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by paul on 9/2/2020 at 5:44 PM.
 */
@Dao
interface BlogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogEntity: BlogCacheEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(blogEntity: List<BlogCacheEntity>)

    @Query("SELECT * FROM blogs")
    suspend fun getAll(): List<BlogCacheEntity>
}