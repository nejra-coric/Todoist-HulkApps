package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.mappers.TaskMapper
import com.hulkapps.restservicetodoapp.repository.TaskRepository
import com.hulkapps.restservicetodoapp.utils.exceptions.TaskException
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl (
    private val taskRepository: TaskRepository,
    private val taskMapper: TaskMapper
) : TaskService {
    override fun createTask(taskDTO: TaskDTO): TaskDTO {
        if (taskDTO.id != -1)
            throw TaskException("ID must be null or -1")

        // Deklarisanje taska kao explicitnog tipa je rijesilo bug za -1
        val task = taskRepository.save(taskMapper.toEntity(taskDTO))

        return taskMapper.fromEntity(task)
    }
    // Overridujemo funkciju u TaskService-u kako bi mogli izvrsiti implementaciju na istoj
    override fun getTasks(): List<TaskDTO> {
        // Constanta za Iterable ( Iterable pretvara datu u list strukturu
        // na definiciji vucemo metodu findAll kako bi prepoznao sve.
        val tasks = taskRepository.getAllTasks()  // Lazy mutabilna funkcija kako bi se prebacila data u listu
        // Conditional za provjeravanje je li imamo podataka
        if (tasks.isEmpty())
            throw TaskException("List of tasks is empty")
        // Treba nam mapiranje  kako bi mogli izvlaciti datu za svaku pojedinacnu jedinku iz liste
        return tasks.map {
            taskMapper.fromEntity(it)
        } // Da bi uspjeli vratiti taskove potrebna nam je abstraktna klasa za nju
    }
    // Get pojedinacnih taskova
    override fun getTask(id: Int): TaskDTO {
        val optionalTask = taskRepository.findById(id)
        val task = optionalTask.orElseThrow {
            TaskException("Movie with $id is not present in the server")
        }
        return taskMapper.fromEntity(task)
    }

    override fun updateTask(taskDTO: TaskDTO): TaskDTO {
        val exists = taskRepository.existsById(taskDTO.id)

        if (!exists)
            throw TaskException("Task with id ${taskDTO.id} is not present")

        taskRepository.save(taskMapper.toEntity(taskDTO))
        return taskDTO
    }
    override fun deleteTask(id: Int) {
        val exists = taskRepository.existsById(id)

        if (!exists)
            throw TaskException("Task with id $id is not present")

        taskRepository.deleteById(id)
    }
}