package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.flight.Aircraft
import ru.zaborskiy.kotlin_spring.domain.repository.AircraftRepository

@Service
class AircraftService(private val aircraftRepository: AircraftRepository) {

    @Transactional
    fun all(): Iterable<Aircraft> = aircraftRepository.findAll()

    @Transactional
    fun get(id: Long): Aircraft = aircraftRepository.findAircraftById(id)

    @Transactional
    fun add(aircraft: Aircraft): Aircraft = aircraftRepository.save(aircraft)

    @Transactional
    fun save(aircraft: Aircraft): Aircraft = aircraftRepository.save(aircraft)

    @Transactional
    fun remove(id: Long) = aircraftRepository.deleteById(id)

}