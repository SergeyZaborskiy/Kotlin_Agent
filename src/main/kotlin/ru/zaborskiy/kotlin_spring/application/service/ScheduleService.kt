package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule
import ru.zaborskiy.kotlin_spring.domain.repository.AirportScheduleRepository

@Service
class ScheduleService(private val airportOperationScheduleRepository: AirportScheduleRepository) {

    @Transactional
    fun all(): Iterable<AirportTechnologicalSchedule> = airportOperationScheduleRepository.findAll()

    @Transactional
    fun get(id: Long): AirportTechnologicalSchedule = airportOperationScheduleRepository.findScheduleById(id)

    @Transactional
    fun add(airportTechnologicalSchedule: AirportTechnologicalSchedule): AirportTechnologicalSchedule =
        airportOperationScheduleRepository.save(airportTechnologicalSchedule)

    @Transactional
    fun save(airportTechnologicalSchedule: AirportTechnologicalSchedule): AirportTechnologicalSchedule =
        airportOperationScheduleRepository.save(airportTechnologicalSchedule)

    @Transactional
    fun remove(id: Long) = airportOperationScheduleRepository.deleteById(id)

    @Transactional
    fun removeObj(airportTechnologicalSchedule: AirportTechnologicalSchedule) =
        airportOperationScheduleRepository.delete(airportTechnologicalSchedule)

    @Transactional
    fun getByAirport(id: Long) = airportOperationScheduleRepository.findAirportScheduleByAirport_Id(id)

}