package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportProduct

@Repository
interface AirportProductRepository : CrudRepository<AirportProduct, Long> {

    fun findServiceById(id: Long): AirportProduct

}