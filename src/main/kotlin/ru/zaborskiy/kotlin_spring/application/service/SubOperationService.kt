package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import ru.zaborskiy.kotlin_spring.domain.repository.SubOperationRepository

@Service
class SubOperationService(private val subOperationRepository: SubOperationRepository) {

    fun all(): Iterable<SubOperation> = subOperationRepository.findAll()

    fun get(id: Long): SubOperation = subOperationRepository.findSubOperationById(id)

    fun add(operation: SubOperation): SubOperation = subOperationRepository.save(operation)

    fun save(operation: SubOperation): SubOperation = subOperationRepository.save(operation)

    fun remove(id: Long) = subOperationRepository.deleteById(id)

}