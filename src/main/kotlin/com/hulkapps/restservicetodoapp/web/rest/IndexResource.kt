package com.hulkapps.restservicetodoapp.web.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HomeController {
    @RequestMapping("/")
    fun welcome(): String {
        return "Welcome to our Rest API, please refer to /epics or /tasks until we write a documentation :)"
    }
}