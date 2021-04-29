package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportItem

@Repository
interface AirportItemRepository : CrudRepository<AirportItem, Long> {

    fun findServiceById(id: Long): AirportItem

}