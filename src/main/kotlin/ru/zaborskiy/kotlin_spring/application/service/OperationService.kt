package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineOperation
import ru.zaborskiy.kotlin_spring.domain.repository.AircraftOperationRepository

@Service
class OperationService(private val aircraftOperationRepository: AircraftOperationRepository) {

    @Transactional
    fun all(): Iterable<AirlineOperation> = aircraftOperationRepository.findAll()

    @Transactional
    fun get(id: Long): AirlineOperation = aircraftOperationRepository.findOperationById(id)

    @Transactional
    fun add(airlineOperation: AirlineOperation): AirlineOperation = aircraftOperationRepository.save(airlineOperation)

    @Transactional
    fun save(airlineOperation: AirlineOperation): AirlineOperation = aircraftOperationRepository.save(airlineOperation)

    @Transactional
    fun remove(id: Long) = aircraftOperationRepository.deleteById(id)


}