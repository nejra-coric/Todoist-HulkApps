package com.hulkapps.restservicetodoapp.service

import com.hulkapps.restservicetodoapp.dto.EpicDTO
import com.hulkapps.restservicetodoapp.mappers.EpicMapper
import com.hulkapps.restservicetodoapp.repository.EpicRepository
import com.hulkapps.restservicetodoapp.utils.exceptions.EpicException
import com.hulkapps.restservicetodoapp.utils.exceptions.TaskException
import org.springframework.stereotype.Service


@Service
class EpicServiceImpl (
    private val epicRepository: EpicRepository,
    private val epicMapper: EpicMapper
) : EpicService {
    override fun createEpic(epicDTO: EpicDTO): EpicDTO {
        if (epicDTO.id != -1)
            throw EpicException("ID must be null or -1")

        val epic = epicRepository.save(epicMapper.toEpicEntity(epicDTO))
        return epicMapper.fromEpicEntity(epic)
    }

    override fun getEpics(): List<EpicDTO> {
        val epics = epicRepository.getAllEpics()
        if (epics.isEmpty())
            throw EpicException("List of Epics is empty")

        return epics.map {
            epicMapper.fromEpicEntity(it)
        }
    }

    override fun getEpic(id: Int): EpicDTO {
        val optionalEpic = epicRepository.findById(id)
        val epic = optionalEpic.orElseThrow {
            TaskException("Epic with $id is not present in the server")
        }
        return epicMapper.fromEpicEntity(epic)
    }

    override fun deleteEpic(id: Int) {
        val exists = epicRepository.existsById(id)
        if (!exists)
            throw EpicException("Epic you want to delete does not exist")

        epicRepository.deleteById(id)
    }
}
