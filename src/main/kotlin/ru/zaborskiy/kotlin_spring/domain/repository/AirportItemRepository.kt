package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportServiceForMaintenance

@Repository
interface AirportItemRepository : CrudRepository<AirportServiceForMaintenance, Long> {

    fun findServiceById(id: Long): AirportServiceForMaintenance

}