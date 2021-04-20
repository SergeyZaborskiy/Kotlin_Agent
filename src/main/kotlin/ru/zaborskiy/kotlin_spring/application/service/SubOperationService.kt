package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import ru.zaborskiy.kotlin_spring.domain.repository.SubOperationRepository

@Service
class SubOperationService(private val subOperationRepository: SubOperationRepository) {

    @Transactional
    fun all(): Iterable<SubOperation> = subOperationRepository.findAll()

    @Transactional
    fun get(id: Long): SubOperation = subOperationRepository.findSubOperationById(id)

    @Transactional
    fun add(subOperation: SubOperation): SubOperation = subOperationRepository.save(subOperation)

    @Transactional
    fun save(subOperation: SubOperation): SubOperation = subOperationRepository.save(subOperation)

    @Transactional
    fun remove(id: Long) = subOperationRepository.deleteById(id)

    @Transactional
    fun removeObj(subOperation: SubOperation) = subOperationRepository.delete(subOperation)

}