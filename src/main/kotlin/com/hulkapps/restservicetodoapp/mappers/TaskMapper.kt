package com.hulkapps.restservicetodoapp.mappers

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.dto.Task
import org.springframework.stereotype.Service

@Service
class TaskMapper: Mapper<TaskDTO, Task> {
    override fun fromEntity(entity: Task): TaskDTO = TaskDTO(
        entity.id,
        entity.title,
        entity.description
    )



    override fun toEntity(domain: TaskDTO): Task = Task(
        domain.id,
        domain.title,
        domain.description
    )
}