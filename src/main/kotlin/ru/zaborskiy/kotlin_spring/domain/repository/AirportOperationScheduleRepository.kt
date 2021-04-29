package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportOperationSchedule

@Repository
interface AirportOperationScheduleRepository : CrudRepository<AirportOperationSchedule, Long> {

    fun findScheduleById(id: Long): AirportOperationSchedule

}