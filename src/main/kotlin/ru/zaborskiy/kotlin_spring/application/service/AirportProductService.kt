package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportProduct
import ru.zaborskiy.kotlin_spring.domain.repository.AirportProductRepository

@Service
class AirportProductService(private val airportProductRepository: AirportProductRepository) {

    @Transactional
    fun all(): Iterable<AirportProduct> = airportProductRepository.findAll()

    @Transactional
    fun get(id: Long): AirportProduct = airportProductRepository.findServiceById(id)

    @Transactional
    fun add(airportProduct: AirportProduct): AirportProduct = airportProductRepository.save(airportProduct)

    @Transactional
    fun save(airportProduct: AirportProduct): AirportProduct = airportProductRepository.save(airportProduct)

    @Transactional
    fun remove(id: Long) = airportProductRepository.deleteById(id)

}