package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceGroup
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceOperation
import ru.zaborskiy.kotlin_spring.domain.repository.ServiceOperationRepository

@Service
class ServiceOperationService(private val serviceOperationRepository: ServiceOperationRepository) {


    fun all(): Iterable<ServiceOperation> = serviceOperationRepository.findAll()


    fun get(id: Long): ServiceOperation = serviceOperationRepository.findServiceOperationById(id)


    fun add(serviceOperation: ServiceOperation): ServiceOperation = serviceOperationRepository.save(serviceOperation)


    fun save(serviceOperation: ServiceOperation): ServiceOperation = serviceOperationRepository.save(serviceOperation)


    fun remove(id: Long) = serviceOperationRepository.deleteById(id)


    fun removeObj(serviceOperation: ServiceOperation) = serviceOperationRepository.delete(serviceOperation)

}