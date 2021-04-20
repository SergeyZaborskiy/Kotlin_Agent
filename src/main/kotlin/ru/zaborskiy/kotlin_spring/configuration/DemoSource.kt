package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.AirportServiceService
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.application.service.SubOperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import javax.annotation.PostConstruct

@Configuration
class DemoSource(
    private val operationService: OperationService,
    private val airportServiceService: AirportServiceService
) {

    @PostConstruct
    fun demoSource() {
        //Operations demo
        var operation1 = Operation()
        operation1.name = "Прием ВС / Выпуск ВС"
        var subOperation1 = SubOperation(name = "Прием ВС / Выпуск ВС с конусами безопасности")
        var subOperation2 = SubOperation(name = "Прием ВС / Выпуск ВС без конусов безопасности")
        operation1.addSubOperationToOperation(subOperation1)
        operation1.addSubOperationToOperation(subOperation2)

        var operation2 = Operation()
        operation2.name = "Буксировка"
        var subOperation3 = SubOperation(name = "Буксировка с водило")
        var subOperation4 = SubOperation(name = "Буксировка без водило")
        operation2.addSubOperationToOperation(subOperation3)
        operation2.addSubOperationToOperation(subOperation4)

        var operation3 = Operation()
        operation3.name = "ВСУ"
        var subOperation5 = SubOperation(name = "ВСУ")
        operation3.addSubOperationToOperation(subOperation5)

        var operation4 = Operation()
        operation4.name = "НИП"
        var subOperation6 = SubOperation(name = "НИП стационарный")
        var subOperation7 = SubOperation(name = "НИП передвижной")
        operation4.addSubOperationToOperation(subOperation6)
        operation4.addSubOperationToOperation(subOperation7)

        operationService.add(operation1)
        operationService.add(operation2)
        operationService.add(operation3)
        operationService.add(operation4)

        //Services demo
        var service1 = AirportService(name = "Осмотр МС и прием воздушного судна на место стоянки")
        var service2 = AirportService(name = "Установка стояночных колодок под колеса шасси")
        var service3 = AirportService(name = "Установка конусов безопасности")
        var service4 = AirportService(name = "Подсоединение наземного источника питания")
        var service5 = AirportService(name = "Уборка стояночных колодок")
        var service6 = AirportService(name = "Отключение наземного источника питания")
        var service7 = AirportService(name = "Предполётный осмотр ВС")
        var service8 = AirportService(name = "Наблюдение за запуском двигателей")

        airportServiceService.add(service1)
        airportServiceService.add(service2)
        airportServiceService.add(service3)
        airportServiceService.add(service4)
        airportServiceService.add(service5)
        airportServiceService.add(service6)
        airportServiceService.add(service7)
        airportServiceService.add(service8)
    }
}