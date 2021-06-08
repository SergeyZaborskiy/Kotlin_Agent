package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.operation.TechnologicalOperation

@Repository
interface AircraftOperationRepository : JpaRepository<TechnologicalOperation, Long> {

    fun findOperationById(id: Long): TechnologicalOperation

}