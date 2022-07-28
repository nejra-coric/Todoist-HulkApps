package com.hulkapps.restservicetodoapp.mappers

interface Mapper<D, E> {
    fun fromEntity(entity: E): D
    fun toEntity(domain: D): E
}