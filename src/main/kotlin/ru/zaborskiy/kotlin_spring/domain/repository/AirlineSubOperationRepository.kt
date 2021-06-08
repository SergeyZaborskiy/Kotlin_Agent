package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceGroup

@Repository
interface AirlineSubOperationRepository : JpaRepository<ServiceGroup, Long> {

    fun findSubOperationById(id: Long): ServiceGroup

}