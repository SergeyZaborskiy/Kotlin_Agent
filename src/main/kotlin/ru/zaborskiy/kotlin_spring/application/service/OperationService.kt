package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.repository.OperationRepository

@Service
class OperationService(private val operationRepository: OperationRepository) {

    @Transactional
    fun all(): Iterable<Operation> = operationRepository.findAll()

    @Transactional
    fun get(id: Long): Operation = operationRepository.findOperationById(id)

    @Transactional
    fun add(operation: Operation): Operation = operationRepository.save(operation)

    @Transactional
    fun save(operation: Operation): Operation = operationRepository.save(operation)

    @Transactional
    fun remove(id: Long) = operationRepository.deleteById(id)



}