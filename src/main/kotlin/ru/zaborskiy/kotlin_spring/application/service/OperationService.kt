package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.TechnologicalOperation
import ru.zaborskiy.kotlin_spring.domain.repository.AircraftOperationRepository

@Service
class OperationService(private val aircraftOperationRepository: AircraftOperationRepository) {

    @Transactional
    fun all(): Iterable<TechnologicalOperation> = aircraftOperationRepository.findAll()

    @Transactional
    fun get(id: Long): TechnologicalOperation = aircraftOperationRepository.findOperationById(id)

    @Transactional
    fun add(technologicalOperation: TechnologicalOperation): TechnologicalOperation = aircraftOperationRepository.save(technologicalOperation)

    @Transactional
    fun save(technologicalOperation: TechnologicalOperation): TechnologicalOperation = aircraftOperationRepository.save(technologicalOperation)

    @Transactional
    fun remove(id: Long) = aircraftOperationRepository.deleteById(id)


}