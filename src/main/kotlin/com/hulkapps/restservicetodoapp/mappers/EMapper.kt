package com.hulkapps.restservicetodoapp.mappers

interface EMapper<D, E> {
    fun fromEpicEntity(entity: E): D
    fun toEpicEntity(domain: D): E
}