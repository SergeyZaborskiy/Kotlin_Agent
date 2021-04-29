package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.Airport

@Repository
interface AirportRepository : CrudRepository<Airport, Long> {

    fun findAirportById(id: Long): Airport

}