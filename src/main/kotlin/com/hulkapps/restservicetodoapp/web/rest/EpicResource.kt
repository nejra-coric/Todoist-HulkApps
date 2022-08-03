package com.hulkapps.restservicetodoapp.web.rest

import com.hulkapps.restservicetodoapp.dto.EpicDTO
import com.hulkapps.restservicetodoapp.service.EpicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EpicResource (
    private val epicService: EpicService
) {
    @PostMapping("/epics")
    fun createEpic(@RequestBody epicDTO: EpicDTO): ResponseEntity<EpicDTO> {
        return ResponseEntity(epicService.createEpic(epicDTO), HttpStatus.CREATED)
    }
    @GetMapping("/epics")
    fun getEpics(): ResponseEntity<List<EpicDTO>> = ResponseEntity.ok(epicService.getEpics())

    @GetMapping("/epics/{id}")
    fun getEpic(@PathVariable id: Int) = ResponseEntity.ok(epicService.getEpic(id))

    @DeleteMapping("/epics/{id}")
    fun deleteEpic(@PathVariable id: Int): ResponseEntity<Unit> =
        ResponseEntity(epicService.deleteEpic(id), HttpStatus.NO_CONTENT)
}