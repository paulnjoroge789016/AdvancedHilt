package com.portfolio.advanceddi.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by paul on 9/2/2020 at 4:45 PM.
 */
class BlogNetworkEntity(
    @SerializedName("body")
    @Expose
    var body: String,

    @SerializedName("category")
    @Expose
    var category: String,

    @SerializedName("image")
    @Expose
    var image: String,

    @SerializedName("pk")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String
)