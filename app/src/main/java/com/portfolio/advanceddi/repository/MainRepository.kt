package com.portfolio.advanceddi.repository

import com.portfolio.advanceddi.model.Blog
import com.portfolio.advanceddi.retrofit.BlogRetrofit
import com.portfolio.advanceddi.retrofit.NetworkMapper
import com.portfolio.advanceddi.room.BlogDao
import com.portfolio.advanceddi.room.CacheMapper
import com.portfolio.advanceddi.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by paul on 9/2/2020 at 9:13 PM.
 */
class MainRepository constructor(private val blogDao: BlogDao,
                                         private val blogRetrofit: BlogRetrofit,
                                         private val cacheMapper: CacheMapper,
                                         private val networkMapper: NetworkMapper) {

    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogRetrofit.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs  = blogDao.getAll()
            emit(DataState.Success(cacheMapper.mapFromEntityLis(cachedBlogs)))

        }catch (ex: Exception){
            emit(DataState.Error(ex))
        }
    }
}