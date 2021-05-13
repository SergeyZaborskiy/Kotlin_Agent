package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportSchedule
import ru.zaborskiy.kotlin_spring.domain.repository.AirportScheduleRepository

@Service
class ScheduleService(private val airportOperationScheduleRepository: AirportScheduleRepository) {

    @Transactional
    fun all(): Iterable<AirportSchedule> = airportOperationScheduleRepository.findAll()

    @Transactional
    fun get(id: Long): AirportSchedule = airportOperationScheduleRepository.findScheduleById(id)

    @Transactional
    fun add(airportSchedule: AirportSchedule): AirportSchedule =
        airportOperationScheduleRepository.save(airportSchedule)

    @Transactional
    fun save(airportSchedule: AirportSchedule): AirportSchedule =
        airportOperationScheduleRepository.save(airportSchedule)

    @Transactional
    fun remove(id: Long) = airportOperationScheduleRepository.deleteById(id)

    @Transactional
    fun removeObj(airportSchedule: AirportSchedule) =
        airportOperationScheduleRepository.delete(airportSchedule)

    @Transactional
    fun getByAirport(id: Long) = airportOperationScheduleRepository.findAirportScheduleByAirport_Id(id)

}