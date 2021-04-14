package ru.zaborskiy.kotlin_spring.application.service

import ru.zaborskiy.kotlin_spring.domain.entity.Aircraft
import ru.zaborskiy.kotlin_spring.domain.entity.Airport
import ru.zaborskiy.kotlin_spring.domain.entity.Flight
import ru.zaborskiy.kotlin_spring.domain.entity.Schedule
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Service
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation

class VirtualSQL {
    var listOfAircraft = mutableListOf<Aircraft>()
        get() = field

    var listOfAirports = mutableListOf<Airport>()
        get() = field

    var listOfOperations = mutableListOf<Operation>()
        get() = field

    var listOfSubOperations = mutableListOf<SubOperation>()
        get() = field

    var listOfServices = mutableListOf<Service>()
        get() = field

    var listOfFlight = mutableListOf<Flight>()
        get() = field

    var listOfSchedule = mutableListOf<Schedule>()
        get() = field

    //Save or Update
    fun saveOrUpdateAircraft(aircraft: Aircraft) {
        listOfAircraft.add(aircraft)
    }

    fun saveOrUpdateAirport(airport: Airport) {
        listOfAirports.add(airport)
    }

    fun saveOrUpdateOperation(operation: Operation) {
        listOfOperations.add(operation)
    }

    fun saveOrUpdateSubOperation(subOperation: SubOperation) {
        listOfSubOperations.add(subOperation)
    }

    fun saveOrUpdateService(service: Service){
        listOfServices.add(service)
    }

    fun saveOrUpdateSchedule(schedule: Schedule){
        listOfSchedule.add(schedule)
    }

    //
}
