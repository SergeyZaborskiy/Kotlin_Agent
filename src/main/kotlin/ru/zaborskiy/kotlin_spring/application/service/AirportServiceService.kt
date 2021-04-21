package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportService
import ru.zaborskiy.kotlin_spring.domain.repository.AirportServiceRepository

@Service
class AirportServiceService(private val airportServiceRepository: AirportServiceRepository) {


    fun all(): Iterable<AirportService> = airportServiceRepository.findAll()


    fun get(id: Long): AirportService = airportServiceRepository.findServiceById(id)


    fun add(airportService: AirportService): AirportService = airportServiceRepository.save(airportService)


    fun save(airportService: AirportService): AirportService = airportServiceRepository.save(airportService)


    fun remove(id: Long) = airportServiceRepository.deleteById(id)

}