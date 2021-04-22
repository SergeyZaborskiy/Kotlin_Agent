package ru.zaborskiy.kotlin_spring.application.service

import org.springframework.stereotype.Service
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportProduct
import ru.zaborskiy.kotlin_spring.domain.repository.AirportProductRepository

@Service
class AirportProductService(private val airportProductRepository: AirportProductRepository) {


    fun all(): Iterable<AirportProduct> = airportProductRepository.findAll()


    fun get(id: Long): AirportProduct = airportProductRepository.findServiceById(id)


    fun add(airportProduct: AirportProduct): AirportProduct = airportProductRepository.save(airportProduct)


    fun save(airportProduct: AirportProduct): AirportProduct = airportProductRepository.save(airportProduct)


    fun remove(id: Long) = airportProductRepository.deleteById(id)

}