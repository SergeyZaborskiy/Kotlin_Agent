package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.Airport
import ru.zaborskiy.kotlin_spring.domain.repository.AirportRepository

@Service
class AirportService(private val airportRepository: AirportRepository) {

    @Transactional
    fun all(): Iterable<Airport> = airportRepository.findAll()

    @Transactional
    fun get(id: Long): Airport = airportRepository.findAirportById(id)

    @Transactional
    fun add(airport: Airport): Airport = airportRepository.save(airport)

    @Transactional
    fun save(airport: Airport): Airport = airportRepository.save(airport)

    @Transactional
    fun remove(id: Long) = airportRepository.deleteById(id)

}