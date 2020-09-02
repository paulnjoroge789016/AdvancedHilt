package com.portfolio.advanceddi.retrofit

import com.portfolio.advanceddi.model.Blog
import com.portfolio.advanceddi.util.EntityMapper
import javax.inject.Inject

/**
 * Created by paul on 9/2/2020 at 4:53 PM.
 */
class NetworkMapper @Inject constructor(): EntityMapper<BlogNetworkEntity, Blog>{
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            body = entity.body,
            category = entity.category,
            image = entity.image,
            id = entity.id,
            title = entity.title
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
      return BlogNetworkEntity(
          body = domainModel.body,
          category = domainModel.category,
          image = domainModel.image,
          id = domainModel.id,
          title = domainModel.title
      )
    }

    fun mapFromEntityList(entities: List<BlogNetworkEntity>): List<Blog>{
        return entities.map { mapFromEntity(it) }
    }

}