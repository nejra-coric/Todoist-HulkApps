package com.hulkapps.restservicetodoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class RestserviceTodoappApplication {

	@GetMapping
	fun firstTest() = "Prvi test"
}

fun main(args: Array<String>) {
	runApplication<RestserviceTodoappApplication>(*args)
}
