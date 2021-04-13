package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.AircraftDAO
import ru.zaborskiy.kotlin_spring.domain.entity.Aircraft

@Configuration
class DemoSource {

    val dao:AircraftDAO = AircraftDAO()

    fun demoSource() {
        var plane1 = Aircraft()
        plane1.name = "SU-9"
        plane1.maxFuel = 100

        var plane2 = Aircraft()
        plane2.name = "727-400"
        plane2.maxFuel = 200

        dao.addAircraft(plane1)
        dao.addAircraft(plane2)

    }
}