package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.TaskDTO

interface TaskService {
    fun createTask(taskDTO: TaskDTO): TaskDTO
}