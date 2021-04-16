package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.application.service.SubOperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import javax.annotation.PostConstruct

@Configuration
class DemoSource(private val operationService: OperationService, private val subOperationService: SubOperationService) {

    @PostConstruct
    fun demoSource() {

        var operation1 = Operation()
        operation1.name = "Загрузка"
        var subOperation1 = SubOperation(name = "Загрузка1", operation = operation1)
        var subOperation2 = SubOperation(name = "Загрузка2", operation = operation1)
        var subOperation3 = SubOperation(name = "Загрузка3", operation = operation1)

        var operation2 = Operation()
        operation2.name = "Выгрузка"

        operationService.add(operation1)
        operationService.add(operation2)
        subOperationService.add(subOperation1)
        subOperationService.add(subOperation2)
        subOperationService.add(subOperation3)

    }
}