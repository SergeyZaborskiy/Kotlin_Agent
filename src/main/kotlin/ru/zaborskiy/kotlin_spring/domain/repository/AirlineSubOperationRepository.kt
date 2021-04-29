package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineSubOperation

@Repository
interface AirlineSubOperationRepository : JpaRepository<AirlineSubOperation, Long> {

    fun findSubOperationById(id: Long): AirlineSubOperation

}