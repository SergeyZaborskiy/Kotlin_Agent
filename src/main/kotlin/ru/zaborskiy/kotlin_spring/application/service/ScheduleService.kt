package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import ru.zaborskiy.kotlin_spring.domain.entity.Schedule
import ru.zaborskiy.kotlin_spring.domain.repository.ScheduleRepository

@Service
class ScheduleService(private val scheduleRepository: ScheduleRepository) {

    fun all(): Iterable<Schedule> = scheduleRepository.findAll()


    fun get(id: Long): Schedule = scheduleRepository.findScheduleById(id)


    fun add(schedule: Schedule): Schedule = scheduleRepository.save(schedule)


    fun save(schedule: Schedule): Schedule = scheduleRepository.save(schedule)


    fun remove(id: Long) = scheduleRepository.deleteById(id)


    fun removeObj(schedule: Schedule) = scheduleRepository.delete(schedule)

}