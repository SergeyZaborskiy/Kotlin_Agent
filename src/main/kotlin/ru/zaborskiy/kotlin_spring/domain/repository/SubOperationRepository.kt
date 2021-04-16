package ru.zaborskiy.kotlin_spring.domain.repository

import org.springframework.data.repository.CrudRepository

import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation

interface SubOperationRepository:CrudRepository<SubOperation, Long> {

    fun findSubOperationById(id: Long): SubOperation

}