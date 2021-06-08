package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.*
import ru.zaborskiy.kotlin_spring.domain.entity.ScheduleType
import ru.zaborskiy.kotlin_spring.domain.entity.flight.Aircraft
import ru.zaborskiy.kotlin_spring.domain.entity.airport.Airport
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule
import ru.zaborskiy.kotlin_spring.domain.entity.operation.TechnologicalOperation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceGroup
import javax.annotation.PostConstruct

@Configuration
class DemoSource(
    private val operationService: OperationService,
    private val airportService: AirportService,
    private val aircraftService: AircraftService,
    private val scheduleService: ScheduleService,
    private val subOperationService: SubOperationService

) {

    @PostConstruct
    fun demoSource() {
        //Operations demo
        var operation1 = TechnologicalOperation()
        operation1.name = "Прием ВС / Выпуск ВС"
        var subOperation1 = ServiceGroup(name = "Прием ВС / Выпуск ВС с конусами безопасности")
        var subOperation2 = ServiceGroup(name = "Прием ВС / Выпуск ВС без конусов безопасности")
        operation1.addSubOperation(subOperation1)
        operation1.addSubOperation(subOperation2)

        var operation2 = TechnologicalOperation()
        operation2.name = "Буксировка"
        var subOperation3 = ServiceGroup(name = "Буксировка с водило")
        var subOperation4 = ServiceGroup(name = "Буксировка без водило")
        operation2.addSubOperation(subOperation3)
        operation2.addSubOperation(subOperation4)

        var operation3 = TechnologicalOperation()
        operation3.name = "ВСУ"
        var subOperation5 = ServiceGroup(name = "ВСУ")
        operation3.addSubOperation(subOperation5)

        var operation4 = TechnologicalOperation()
        operation4.name = "НИП"
        var subOperation6 = ServiceGroup(name = "НИП стационарный")
        var subOperation7 = ServiceGroup(name = "НИП передвижной")
        operation4.addSubOperation(subOperation6)
        operation4.addSubOperation(subOperation7)

        //Aircraft demo
        var aircraft1 = Aircraft(name = "SU-9")
        var aircraft2 = Aircraft(name = "737-800NG")
        var aircraft3 = Aircraft(name = "A320")

        //Airport demo
        var airport1 =
            Airport(name = "PULKOVO", icao = "ULLI", iata = "LED", country = "Russia", city = "Saint-Petersburg")
        var airport2 = Airport(name = "DOMODEDOVO", icao = "UUDD", iata = "DME", country = "Russia", city = "Moscow")

        //Schedule demo

        var airportSchedule = AirportTechnologicalSchedule()
        airportSchedule.airport = airport1
        airportSchedule.aircraft = aircraft1
        airportSchedule.scheduleType = ScheduleType.Arrival.type
        airportSchedule.addAirlineOperation(operation1)
        airportSchedule.addAirlineOperation(operation2)
        airportSchedule.addAirlineOperation(operation3)
        airportSchedule.addAirlineOperation(operation4)


                //save

        airportService.add(airport1)
        airportService.add(airport2)

        aircraftService.add(aircraft1)
        aircraftService.add(aircraft2)
        aircraftService.add(aircraft3)

        operationService.add(operation1)
        operationService.add(operation2)
        operationService.add(operation3)
        operationService.add(operation4)


    }
}