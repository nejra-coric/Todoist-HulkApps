package com.hulkapps.restservicetodoapp.mappers

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.entity.Task

class TaskMapper: Mapper<TaskDTO, Task> {
    override fun fromEntity(entity: Task): TaskDTO = TaskDTO(
        entity.id,
        entity.title,
        entity.description
    )



    override fun fromDTO(domain: TaskDTO): Task = Task(
        domain.id,
        domain.title,
        domain.description
    )
}