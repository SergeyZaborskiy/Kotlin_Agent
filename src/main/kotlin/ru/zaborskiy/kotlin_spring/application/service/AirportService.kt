package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import ru.zaborskiy.kotlin_spring.domain.entity.Airport
import ru.zaborskiy.kotlin_spring.domain.repository.AirportRepository

@Service
class AirportService(private val airportRepository: AirportRepository) {

    fun all(): Iterable<Airport> = airportRepository.findAll()


    fun get(id: Long): Airport = airportRepository.findAirportById(id)


    fun add(airport: Airport): Airport = airportRepository.save(airport)


    fun save(airport: Airport): Airport = airportRepository.save(airport)


    fun remove(id: Long) = airportRepository.deleteById(id)

}