package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.Schedule
import ru.zaborskiy.kotlin_spring.domain.repository.ScheduleRepository

@Service
class ScheduleService(private val scheduleRepository: ScheduleRepository) {

    @Transactional
    fun all(): Iterable<Schedule> = scheduleRepository.findAll()

    @Transactional
    fun get(id: Long): Schedule = scheduleRepository.findScheduleById(id)

    @Transactional
    fun add(schedule: Schedule): Schedule = scheduleRepository.save(schedule)

    @Transactional
    fun save(schedule: Schedule): Schedule = scheduleRepository.save(schedule)

    @Transactional
    fun remove(id: Long) = scheduleRepository.deleteById(id)

    @Transactional
    fun removeObj(schedule: Schedule) = scheduleRepository.delete(schedule)

}