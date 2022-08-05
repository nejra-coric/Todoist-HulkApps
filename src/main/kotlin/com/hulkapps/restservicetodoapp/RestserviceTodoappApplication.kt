package com.hulkapps.restservicetodoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse


@SpringBootApplication
class RestserviceTodoappApplication



fun main(args: Array<String>) {
	runApplication<RestserviceTodoappApplication>(*args)
}
