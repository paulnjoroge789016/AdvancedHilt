package com.portfolio.advanceddi.room

import com.portfolio.advanceddi.model.Blog
import com.portfolio.advanceddi.util.EntityMapper
import org.w3c.dom.Entity
import javax.inject.Inject

/**
 * Created by paul on 9/2/2020 at 5:32 PM.
 */
class CacheMapper @Inject constructor(): EntityMapper<BlogCacheEntity, Blog>{
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
       return Blog(
           body = entity.body,
           category = entity.category,
           image = entity.image,
           id = entity.id,
           title = entity.title
       )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            body = domainModel.body,
            category = domainModel.category,
            image = domainModel.image,
            id = domainModel.id,
            title = domainModel.title
        )
    }

    fun mapFromEntityLis(entities: List<BlogCacheEntity>) : List<Blog> {
        return entities.map { mapFromEntity(it) }
    }

}