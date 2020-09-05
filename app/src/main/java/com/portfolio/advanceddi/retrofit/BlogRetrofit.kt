package com.portfolio.advanceddi.retrofit

import retrofit2.http.GET

/**
 * Created by paul on 9/2/2020 at 4:48 PM.
 */
interface BlogRetrofit {
    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}