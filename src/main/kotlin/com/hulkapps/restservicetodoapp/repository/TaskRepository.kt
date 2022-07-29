package com.hulkapps.restservicetodoapp.repository

import com.hulkapps.restservicetodoapp.dto.Task
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

// Prosirujemo interface od TaskRepositorija ( CRUD - Create/Read/Update/Delete )
interface TaskRepository: CrudRepository<Task, Int> {
    @Query("SELECT t FROM Task as t")
    // Kako bi komunicirali sa databasom (mySQLom) moramo uvesti query koji ce znati odakle da izvuce podatke
    fun getAllTasks(): List<Task>
}