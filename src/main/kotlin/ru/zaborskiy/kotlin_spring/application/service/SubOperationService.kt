package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import ru.zaborskiy.kotlin_spring.domain.repository.SubOperationRepository

@Service
class SubOperationService(private val subOperationRepository: SubOperationRepository) {


    fun all(): Iterable<SubOperation> = subOperationRepository.findAll()


    fun get(id: Long): SubOperation = subOperationRepository.findSubOperationById(id)


    fun add(subOperation: SubOperation): SubOperation = subOperationRepository.save(subOperation)


    fun save(subOperation: SubOperation): SubOperation = subOperationRepository.save(subOperation)


    fun remove(id: Long) = subOperationRepository.deleteById(id)


    fun removeObj(subOperation: SubOperation) = subOperationRepository.delete(subOperation)

}