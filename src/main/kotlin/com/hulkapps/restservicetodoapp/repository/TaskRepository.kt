package com.hulkapps.restservicetodoapp.repository

import com.hulkapps.restservicetodoapp.dto.Task
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface TaskRepository: CrudRepository<Task, Int> {
    @Query("SELECT t FROM Task as t")
    fun getAllTasks(): List<Task>
}