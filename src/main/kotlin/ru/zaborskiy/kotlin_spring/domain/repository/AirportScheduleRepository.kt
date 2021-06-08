package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule

@Repository
interface AirportScheduleRepository : CrudRepository<AirportTechnologicalSchedule, Long> {

    fun findScheduleById(id: Long): AirportTechnologicalSchedule

    fun findAirportScheduleByAirport_Id(id:Long): List<AirportTechnologicalSchedule>

}