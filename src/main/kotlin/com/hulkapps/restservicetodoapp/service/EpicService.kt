package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.EpicDTO
import javax.persistence.Id

interface EpicService {
    fun createEpic(epicDTO: EpicDTO): EpicDTO

    fun getEpics(): List<EpicDTO>

    fun getEpic(id: Int): EpicDTO

    fun deleteEpic(id: Int)
}