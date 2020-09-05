package com.portfolio.advanceddi.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by paul on 9/2/2020 at 5:25 PM.
 */
@Entity(tableName = "blogs")
class BlogCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "category")
    var category: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "body")
    var body: String


)