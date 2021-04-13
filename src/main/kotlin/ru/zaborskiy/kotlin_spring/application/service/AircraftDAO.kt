package ru.zaborskiy.kotlin_spring.application.service

import ru.zaborskiy.kotlin_spring.domain.entity.Aircraft

class AircraftDAO {
    var listOfAircraft = mutableListOf<Aircraft>()
        get() = field

    fun addAircraft(aircraft: Aircraft){
        listOfAircraft.add(aircraft)
    }

}