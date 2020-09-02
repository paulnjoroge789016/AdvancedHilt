package com.portfolio.advanceddi.util

/**
 * Created by paul on 9/2/2020 at 4:51 PM.
 */
interface EntityMapper <Entity, DomainModel>{

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel): Entity
}