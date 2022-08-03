package com.hulkapps.restservicetodoapp.repository

import com.hulkapps.restservicetodoapp.entity.Epic
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface EpicRepository: CrudRepository<Epic, Int> {

    @Query("Select e from Epic as e")
    fun getAllEpics(): List<Epic>
}