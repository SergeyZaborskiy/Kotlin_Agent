package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.OperationService
import ru.zaborskiy.kotlin_spring.application.service.SubOperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
@RequestMapping("/references/operations")
class OperationReferenceController(private val operationService: OperationService) {

    @GetMapping
    fun getOperationsList(model: Model): String {
        model.addAttribute("operationsList", operationService.all())
        return "/references/operations/operations_view"
    }

    @GetMapping("/new")
    fun getOperationForm(model: Model): String {
        var operation = Operation()
        model.addAttribute("operation", operation)
        return "/references/operations/operation_form"
    }

    @PostMapping
    fun addOperation(@ModelAttribute operation: Operation): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        operation.timeDateModified = LocalDateTime.now().format(formatter)
        operation.userModified = auth.name
        operationService.add(operation)
        return "redirect:/references/operations"
    }

    @GetMapping("/{operationId}")
    fun editOperation(@PathVariable operationId: Long, model: Model): String {
        var operation = operationService.get(operationId)
        model.addAttribute(operation)
        return "/references/operations/operation_form"
    }

    @DeleteMapping("/{id}")
    fun deleteOperation(@PathVariable id: Long): String {
        operationService.remove(id)
        return "redirect:/references/operations"
    }
}