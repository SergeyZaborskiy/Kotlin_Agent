package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.Schedule

@Repository
interface ScheduleRepository : CrudRepository<Schedule, Long> {

    fun findScheduleById(id: Long): Schedule

}