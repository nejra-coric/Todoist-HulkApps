package com.hulkapps.restservicetodoapp.web.rest

import com.hulkapps.restservicetodoapp.dto.TaskDTO
import com.hulkapps.restservicetodoapp.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskResource(
    private val taskService: TaskService
) {
   @PostMapping
   fun createTask(@RequestBody taskDTO: TaskDTO): ResponseEntity<TaskDTO> {
       try {
           return ResponseEntity(taskService.createTask(taskDTO), HttpStatus.CREATED)
       }
       catch(exception: IllegalArgumentException) {
           return ResponseEntity(null, HttpStatus.BAD_REQUEST)
       }
   }
}