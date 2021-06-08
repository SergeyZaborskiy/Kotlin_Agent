package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceGroup
import ru.zaborskiy.kotlin_spring.domain.repository.AirlineSubOperationRepository

@Service
class SubOperationService(private val airlineSubOperationRepository: AirlineSubOperationRepository) {


    @Transactional
    fun all(): Iterable<ServiceGroup> = airlineSubOperationRepository.findAll()

    @Transactional
    fun get(id: Long): ServiceGroup = airlineSubOperationRepository.findSubOperationById(id)

    @Transactional
    fun add(subOperation: ServiceGroup): ServiceGroup = airlineSubOperationRepository.save(subOperation)

    @Transactional
    fun save(subOperation: ServiceGroup): ServiceGroup = airlineSubOperationRepository.save(subOperation)

    @Transactional
    fun remove(id: Long) = airlineSubOperationRepository.deleteById(id)

    @Transactional
    fun removeObj(subOperation: ServiceGroup) = airlineSubOperationRepository.delete(subOperation)

}