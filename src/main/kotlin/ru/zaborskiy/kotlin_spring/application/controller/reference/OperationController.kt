package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.SubOperationService
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.application.service.ServiceOperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.TechnologicalOperation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceGroup
import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceOperation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/operations")
class OperationController(
    private val operationService: OperationService,
    private val subOperationService: SubOperationService,
    private val serviceOperationService: ServiceOperationService
) {

    @GetMapping
    fun getOperationsList(model: Model): String {
        model.addAttribute("operationsList", operationService.all())
        return "/operations/operations_view"
    }

    @GetMapping("/new")
    fun getOperationForm(model: Model): String {
        var operation = TechnologicalOperation()
        model.addAttribute("newOperation", operation)
        return "/operations/operation_new"
    }

    @GetMapping("/{operationId}")
    fun editOperation(@PathVariable operationId: Long, model: Model): String {
        var operation = operationService.get(operationId)
        model.addAttribute("returnedOperation", operation)
        var subOperation = ServiceGroup()
        var serviceOperation = ServiceOperation()
        model.addAttribute("newSubOperation", subOperation)
        model.addAttribute("newServiceOperation", serviceOperation)
        return "/operations/operation_form"
    }

    @PostMapping
    fun addOperation(@ModelAttribute technologicalOperation: TechnologicalOperation, model: Model): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        technologicalOperation.timeDateModified = LocalDateTime.now().format(formatter)
        technologicalOperation.userModified = auth.name
        operationService.add(technologicalOperation)
        return "redirect:/operations"
    }

    @PostMapping("/sub")
    fun addSubOperation(@ModelAttribute subOperation: ServiceGroup, request: HttpServletRequest): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        subOperation.timeDateModified = LocalDateTime.now().format(formatter)
        subOperation.userModified = auth.name
        subOperationService.add(subOperation)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }

    @DeleteMapping("/{operationId}")
    fun deleteOperation(@PathVariable operationId: Long): String {
        operationService.remove(operationId)
        return "redirect:/operations"
    }

    @DeleteMapping("/sub/{subOperationId}")
    fun deleteSubOperation(@PathVariable subOperationId: Long, request: HttpServletRequest, model: Model): String {
        var temp = subOperationService.get(subOperationId)
        subOperationService.removeObj(temp)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }

    @PostMapping("/serviceOperation/new")
    fun addOperationToSubOperation(@ModelAttribute serviceOperation: ServiceOperation, request: HttpServletRequest, model: Model): String {
        serviceOperationService.add(serviceOperation)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }

    @DeleteMapping("/serviceOperation/{subOperationId}/all")
    fun deleteAllServiceOperation(request: HttpServletRequest, @PathVariable subOperationId: Long): String {
        val temp = subOperationService.get(subOperationId)
        temp.deleteAllServiceOperations()
        subOperationService.save(temp)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }

}