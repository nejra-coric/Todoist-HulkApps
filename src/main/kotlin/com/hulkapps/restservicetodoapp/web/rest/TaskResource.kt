package com.hulkapps.restservicetodoapp.web.rest

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.service.TaskService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskResource(
    private val taskService: TaskService
) {
   @PostMapping
   fun createTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<TaskDTO> {
       return ResponseEntity(taskService.createTask(taskDTO), HttpStatus.CREATED)
   }
   @GetMapping
   // Deklaracija GET/ Endpointa
   fun getTasks(): ResponseEntity<List<TaskDTO>>  = ResponseEntity.ok(taskService.getTasks())

   @GetMapping("/{id}")
   // Pojedinacno po ID-u
   fun getTask(@PathVariable id: Int) = ResponseEntity.ok(taskService.getTask(id))
}