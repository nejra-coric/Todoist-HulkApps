package com.hulkapps.restservicetodoapp.repository

import com.hulkapps.restservicetodoapp.dto.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository: CrudRepository<Task, Int>