package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.flight.Aircraft

@Repository
interface AircraftRepository : CrudRepository<Aircraft, Long> {

    fun findAircraftById(id: Long): Aircraft

}