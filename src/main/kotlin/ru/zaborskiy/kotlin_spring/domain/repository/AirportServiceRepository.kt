package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportService

@Repository
interface AirportServiceRepository : CrudRepository<AirportService, Long> {

    fun findServiceById(id: Long): AirportService

}