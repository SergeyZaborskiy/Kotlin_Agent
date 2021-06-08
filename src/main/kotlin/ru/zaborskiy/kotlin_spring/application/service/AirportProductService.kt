package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportServiceForMaintenance
import ru.zaborskiy.kotlin_spring.domain.repository.AirportItemRepository

@Service
class AirportProductService(private val airportProductRepository: AirportItemRepository) {

    @Transactional
    fun all(): Iterable<AirportServiceForMaintenance> = airportProductRepository.findAll()

    @Transactional
    fun get(id: Long): AirportServiceForMaintenance = airportProductRepository.findServiceById(id)

    @Transactional
    fun add(airportServiceForMaintenance: AirportServiceForMaintenance): AirportServiceForMaintenance = airportProductRepository.save(airportServiceForMaintenance)

    @Transactional
    fun save(airportServiceForMaintenance: AirportServiceForMaintenance): AirportServiceForMaintenance = airportProductRepository.save(airportServiceForMaintenance)

    @Transactional
    fun remove(id: Long) = airportProductRepository.deleteById(id)

}