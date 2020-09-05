package com.portfolio.advanceddi.di

import com.portfolio.advanceddi.repository.MainRepository
import com.portfolio.advanceddi.retrofit.BlogRetrofit
import com.portfolio.advanceddi.retrofit.NetworkMapper
import com.portfolio.advanceddi.room.BlogDao
import com.portfolio.advanceddi.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by paul on 9/2/2020 at 9:32 PM.
 */

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(blogDao: BlogDao,
                              retrofit: BlogRetrofit,
                              cacheMapper: CacheMapper,
                              networkMapper: NetworkMapper
    ): MainRepository{
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}