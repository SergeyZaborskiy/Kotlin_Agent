package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineSubOperation
import ru.zaborskiy.kotlin_spring.domain.repository.AirlineSubOperationRepository

@Service
class SubOperationService(private val airlineSubOperationRepository: AirlineSubOperationRepository) {


    @Transactional
    fun all(): Iterable<AirlineSubOperation> = airlineSubOperationRepository.findAll()

    @Transactional
    fun get(id: Long): AirlineSubOperation = airlineSubOperationRepository.findSubOperationById(id)

    @Transactional
    fun add(subOperation: AirlineSubOperation): AirlineSubOperation = airlineSubOperationRepository.save(subOperation)

    @Transactional
    fun save(subOperation: AirlineSubOperation): AirlineSubOperation = airlineSubOperationRepository.save(subOperation)

    @Transactional
    fun remove(id: Long) = airlineSubOperationRepository.deleteById(id)

    @Transactional
    fun removeObj(subOperation: AirlineSubOperation) = airlineSubOperationRepository.delete(subOperation)

}