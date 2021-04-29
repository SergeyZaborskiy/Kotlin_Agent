package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportItem
import ru.zaborskiy.kotlin_spring.domain.repository.AirportItemRepository

@Service
class AirportProductService(private val airportProductRepository: AirportItemRepository) {

    @Transactional
    fun all(): Iterable<AirportItem> = airportProductRepository.findAll()

    @Transactional
    fun get(id: Long): AirportItem = airportProductRepository.findServiceById(id)

    @Transactional
    fun add(airportItem: AirportItem): AirportItem = airportProductRepository.save(airportItem)

    @Transactional
    fun save(airportItem: AirportItem): AirportItem = airportProductRepository.save(airportItem)

    @Transactional
    fun remove(id: Long) = airportProductRepository.deleteById(id)

}