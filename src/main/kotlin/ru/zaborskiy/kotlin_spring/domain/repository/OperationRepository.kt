package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation

@Repository
interface OperationRepository:CrudRepository<Operation, Long> {

    fun findOperationById(id:Long):Operation

}