package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.TaskDTO

interface TaskService {
    fun createTask(taskDTO: TaskDTO): TaskDTO
    fun getTasks(): List<TaskDTO>
    fun getTask(id: Int): TaskDTO
}