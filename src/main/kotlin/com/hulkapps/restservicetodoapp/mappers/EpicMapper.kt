package com.hulkapps.restservicetodoapp.mappers

import com.hulkapps.restservicetodoapp.dto.EpicDTO
import com.hulkapps.restservicetodoapp.entity.Epic
import org.springframework.stereotype.Service

@Service
class EpicMapper: EMapper<EpicDTO, Epic> {
    override fun fromEpicEntity(entity: Epic): EpicDTO = EpicDTO (
        entity.id,
        entity.title,
        entity.slug,
        entity.conntent
    )

    override fun toEpicEntity(domain: EpicDTO): Epic = Epic (
        domain.id,
        domain.title,
        domain.slug,
        domain.conntent
    )
}