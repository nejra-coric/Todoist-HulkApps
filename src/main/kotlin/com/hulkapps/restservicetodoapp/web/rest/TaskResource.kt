package com.hulkapps.restservicetodoapp.web.rest

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.service.TaskService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TaskResource(
    private val taskService: TaskService
) {
   @PostMapping("/tasks")
   fun createTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<TaskDTO> {
       return ResponseEntity(taskService.createTask(taskDTO), HttpStatus.CREATED)
   }
   @GetMapping("/tasks")
   // Deklaracija GET/ Endpointa
   fun getTasks(): ResponseEntity<List<TaskDTO>>  = ResponseEntity.ok(taskService.getTasks())

   @GetMapping("/{id}")
   // Pojedinacno po ID-u
   fun getTask(@PathVariable id: Int) = ResponseEntity.ok(taskService.getTask(id))

   @PutMapping
   fun updateTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<TaskDTO> =
           ResponseEntity.ok(taskService.updateTask(taskDTO))

   @DeleteMapping("/{id}")
   fun deleteTask(@PathVariable id: Int): ResponseEntity<Unit> =
           ResponseEntity(taskService.deleteTask(id), HttpStatus.NO_CONTENT)
}