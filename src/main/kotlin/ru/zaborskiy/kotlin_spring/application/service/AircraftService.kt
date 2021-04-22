package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import ru.zaborskiy.kotlin_spring.domain.entity.Aircraft
import ru.zaborskiy.kotlin_spring.domain.repository.AircraftRepository

@Service
class AircraftService(private val aircraftRepository: AircraftRepository) {

    fun all(): Iterable<Aircraft> = aircraftRepository.findAll()


    fun get(id: Long): Aircraft = aircraftRepository.findAircraftById(id)


    fun add(aircraft: Aircraft): Aircraft = aircraftRepository.save(aircraft)


    fun save(aircraft: Aircraft): Aircraft = aircraftRepository.save(aircraft)


    fun remove(id: Long) = aircraftRepository.deleteById(id)

}