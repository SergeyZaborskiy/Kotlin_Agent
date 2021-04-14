package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.repository.OperationRepository

@Service
class OperationService(private val operationRepository: OperationRepository) {

    fun all(): Iterable<Operation> = operationRepository.findAll()

    fun get(id: Long): Operation = operationRepository.findOperationById(id)

    fun add(operation: Operation): Operation = operationRepository.save(operation)

    fun save(operation: Operation): Operation = operationRepository.save(operation)

    fun remove(id: Long) = operationRepository.deleteById(id)

}