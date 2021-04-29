package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.SubOperationService
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineOperation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineSubOperation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/operations")
class OperationController(
    private val operationService: OperationService,
    private val subOperationService: SubOperationService
) {

    @GetMapping
    fun getOperationsList(model: Model): String {
        model.addAttribute("operationsList", operationService.all())
        return "/operations/operations_view"
    }

    @GetMapping("/new")
    fun getOperationForm(model: Model): String {
        var operation = AirlineOperation()
        model.addAttribute("returnedOperation", operation)
        var subOperation = AirlineSubOperation()
        model.addAttribute("newSubOperation", subOperation)
        return "/operations/operation_form"
    }

    @GetMapping("/{operationId}")
    fun editOperation(@PathVariable operationId: Long, model: Model): String {
        var operation = operationService.get(operationId)
        model.addAttribute("returnedOperation", operation)
        var subOperation = AirlineSubOperation()
        val addAttribute = model.addAttribute("newSubOperation", subOperation)
        return "/operations/operation_form"
    }

    @PostMapping
    fun addOperation(@ModelAttribute airlineOperation: AirlineOperation, model: Model): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        airlineOperation.timeDateModified = LocalDateTime.now().format(formatter)
        airlineOperation.userModified = auth.name
        operationService.add(airlineOperation)
        return "redirect:/operations"
    }

    @PostMapping("/sub")
    fun addSubOperation(@ModelAttribute subOperation: AirlineSubOperation, request: HttpServletRequest): String {
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
    fun deleteOperation(@PathVariable subOperationId: Long, request: HttpServletRequest, model: Model): String {
        var temp = subOperationService.get(subOperationId)
        subOperationService.removeObj(temp)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }


}