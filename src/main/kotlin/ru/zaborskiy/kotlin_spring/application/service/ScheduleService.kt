package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportOperationSchedule
import ru.zaborskiy.kotlin_spring.domain.repository.AirportOperationScheduleRepository

@Service
class ScheduleService(private val airportOperationScheduleRepository: AirportOperationScheduleRepository) {

    @Transactional
    fun all(): Iterable<AirportOperationSchedule> = airportOperationScheduleRepository.findAll()

    @Transactional
    fun get(id: Long): AirportOperationSchedule = airportOperationScheduleRepository.findScheduleById(id)

    @Transactional
    fun add(airportOperationSchedule: AirportOperationSchedule): AirportOperationSchedule = airportOperationScheduleRepository.save(airportOperationSchedule)

    @Transactional
    fun save(airportOperationSchedule: AirportOperationSchedule): AirportOperationSchedule = airportOperationScheduleRepository.save(airportOperationSchedule)

    @Transactional
    fun remove(id: Long) = airportOperationScheduleRepository.deleteById(id)

    @Transactional
    fun removeObj(airportOperationSchedule: AirportOperationSchedule) = airportOperationScheduleRepository.delete(airportOperationSchedule)

}