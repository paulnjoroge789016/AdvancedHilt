package com.portfolio.advanceddi.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.portfolio.advanceddi.model.Blog
import com.portfolio.advanceddi.retrofit.BlogNetworkEntity
import com.portfolio.advanceddi.retrofit.BlogRetroft
import com.portfolio.advanceddi.retrofit.NetworkMapper
import com.portfolio.advanceddi.util.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by paul on 9/2/2020 at 5:50 PM.
 */


@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyx/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): BlogRetroft{
        return retrofit.build().create(BlogRetroft::class.java)
    }
}