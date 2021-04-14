package ru.zaborskiy.kotlin_spring.configuration

import org.springframework.context.annotation.Configuration
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import javax.annotation.PostConstruct

@Configuration
class DemoSource(private val operationService: OperationService) {

    @PostConstruct
    fun demoSource() {

        var operation1 = Operation()
        operation1.name = "Загрузка"

        var operation2 = Operation()
        operation2.name = "Выгрузка"

        operationService.add(operation1)
        operationService.add(operation2)

    }
}