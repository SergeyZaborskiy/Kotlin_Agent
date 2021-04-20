package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportService
import ru.zaborskiy.kotlin_spring.domain.repository.AirportServiceRepository

@Service
class AirportServiceService(private val airportServiceRepository: AirportServiceRepository) {

    @Transactional
    fun all(): Iterable<AirportService> = airportServiceRepository.findAll()

    @Transactional
    fun get(id: Long): AirportService = airportServiceRepository.findServiceById(id)

    @Transactional
    fun add(airportService: AirportService): AirportService = airportServiceRepository.save(airportService)

    @Transactional
    fun save(airportService: AirportService): AirportService = airportServiceRepository.save(airportService)

    @Transactional
    fun remove(id: Long) = airportServiceRepository.deleteById(id)

}