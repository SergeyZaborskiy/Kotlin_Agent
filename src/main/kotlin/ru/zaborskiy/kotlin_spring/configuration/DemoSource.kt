package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.AircraftService
import ru.zaborskiy.kotlin_spring.application.service.AirportService
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.application.service.ScheduleService
import ru.zaborskiy.kotlin_spring.domain.entity.Aircraft
import ru.zaborskiy.kotlin_spring.domain.entity.Airport
import ru.zaborskiy.kotlin_spring.domain.entity.Schedule
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportProduct
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import javax.annotation.PostConstruct

@Configuration
class DemoSource(
    private val operationService: OperationService,
    private val airportService: AirportService,
    private val aircraftService: AircraftService,
    private val scheduleService: ScheduleService

) {

    @PostConstruct
    fun demoSource() {
        //Operations demo
        var operation1 = Operation()
        operation1.name = "Прием ВС / Выпуск ВС"
        var subOperation1 = SubOperation(name = "Прием ВС / Выпуск ВС с конусами безопасности")
        var subOperation2 = SubOperation(name = "Прием ВС / Выпуск ВС без конусов безопасности")
        operation1.addSubOperationToList(subOperation1)
        operation1.addSubOperationToList(subOperation2)

        var operation2 = Operation()
        operation2.name = "Буксировка"
        var subOperation3 = SubOperation(name = "Буксировка с водило")
        var subOperation4 = SubOperation(name = "Буксировка без водило")
        operation2.addSubOperationToList(subOperation3)
        operation2.addSubOperationToList(subOperation4)

        var operation3 = Operation()
        operation3.name = "ВСУ"
        var subOperation5 = SubOperation(name = "ВСУ")
        operation3.addSubOperationToList(subOperation5)

        var operation4 = Operation()
        operation4.name = "НИП"
        var subOperation6 = SubOperation(name = "НИП стационарный")
        var subOperation7 = SubOperation(name = "НИП передвижной")
        operation4.addSubOperationToList(subOperation6)
        operation4.addSubOperationToList(subOperation7)


        //Services demo
        var service1 = AirportProduct(name = "Осмотр МС и прием воздушного судна на место стоянки")
        var service2 = AirportProduct(name = "Установка стояночных колодок под колеса шасси")
        var service3 = AirportProduct(name = "Установка конусов безопасности")
        var service4 = AirportProduct(name = "Подсоединение наземного источника питания")
        var service5 = AirportProduct(name = "Уборка стояночных колодок")
        var service6 = AirportProduct(name = "Отключение наземного источника питания")
        var service7 = AirportProduct(name = "Предполётный осмотр ВС")
        var service8 = AirportProduct(name = "Наблюдение за запуском двигателей")

        subOperation1.addSubOperationToService(service1)
        subOperation1.addSubOperationToService(service2)
        subOperation1.addSubOperationToService(service3)
        subOperation1.addSubOperationToService(service4)
        subOperation1.addSubOperationToService(service5)
        subOperation1.addSubOperationToService(service6)
        subOperation1.addSubOperationToService(service7)
        subOperation1.addSubOperationToService(service8)

        subOperation2.addSubOperationToService(service1)
        subOperation2.addSubOperationToService(service2)
        subOperation2.addSubOperationToService(service4)
        subOperation2.addSubOperationToService(service5)
        subOperation2.addSubOperationToService(service6)
        subOperation2.addSubOperationToService(service7)
        subOperation2.addSubOperationToService(service8)

        //Aircraft demo
        var aircraft1 = Aircraft(name = "SU-9")
        var aircraft2 = Aircraft(name = "737-800NG")
        var aircraft3 = Aircraft(name = "A320")

        //Airport demo
        var airport1 = Airport(name = "PULKOVO", icao = "ULLI", iata = "LED")
        var airport2 = Airport(name = "DOMODEDOVO", icao = "UUDD", iata = "DME")

        //Schedule demo
        var schedule1 = Schedule()
        schedule1.airport = airport1
        schedule1.aircraft = aircraft1
        schedule1.addOperationToList(operation1)
        schedule1.addOperationToList(operation2)
        schedule1.addOperationToList(operation3)
        schedule1.addOperationToList(operation4)


        //Save demo
        operationService.add(operation1)
        operationService.add(operation2)
        operationService.add(operation3)
        operationService.add(operation4)

        scheduleService.add(schedule1)



    }
}