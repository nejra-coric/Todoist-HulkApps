package com.hulkapps.restservicetodoapp.dto

data class TaskDTO(
    var id: Int = -1,
    var title: String,
    var description: String,
    var priority: String
)

