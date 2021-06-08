package ru.zaborskiy.kotlin_spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceOperation

@Repository
interface ServiceOperationRepository : JpaRepository<ServiceOperation, Long> {

    fun findServiceOperationById(id: Long): ServiceOperation
}