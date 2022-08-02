package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.TaskDTO

interface TaskService {
    fun createTask(taskDTO: TaskDTO): TaskDTO
    // Kreiramo novu funkciju koja ce returnat taskove koje kreiramo sa createTask funkcijom
    // Conforma Listi sa task datom, tj. rezultat koji ocekujemo od nje treba biti ispisan kao list
    // data struktura
    fun getTasks(): List<TaskDTO>

    fun getTask(id: Int): TaskDTO
    fun updateTask(taskDTO: TaskDTO): TaskDTO
    fun deleteTask(id: Int)

}