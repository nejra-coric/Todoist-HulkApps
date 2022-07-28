package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.mappers.TaskMapper
import com.hulkapps.restservicetodoapp.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl (
    private val taskRepository: TaskRepository,
    private val taskMapper: TaskMapper
) : TaskService {
    override fun createTask(taskDTO: TaskDTO): TaskDTO {
        if (taskDTO.id == -1)
            throw IllegalArgumentException("ID must be null or -1")


        val task = taskMapper.toEntity(taskDTO)
        taskRepository.save(task)
        return taskMapper.fromEntity(task)
    }
}