package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportSchedule

@Repository
interface AirportScheduleRepository : CrudRepository<AirportSchedule, Long> {

    fun findScheduleById(id: Long): AirportSchedule

    fun findAirportScheduleByAirport_Id(id:Long): List<AirportSchedule>

}