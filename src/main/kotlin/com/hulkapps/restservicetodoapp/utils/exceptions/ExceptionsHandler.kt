package com.hulkapps.restservicetodoapp.utils.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionsHandler {
    @ExceptionHandler(Exception::class)
    fun generalExceptionsHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message)
        return ResponseEntity(error, error.status)
    }
    @ExceptionHandler(TaskException::class)
    fun taskExceptionHandler(exception: Exception): ResponseEntity<ApiError> {
        val error = ApiError(exception.message)
        return ResponseEntity(error, error.status)
    }
    @ExceptionHandler(EpicException::class)
    fun epicExceptionHandler(exception: EpicException): ResponseEntity<ApiError> {
        val error = ApiError(exception.messages)
        return ResponseEntity(error, error.status)
    }
}