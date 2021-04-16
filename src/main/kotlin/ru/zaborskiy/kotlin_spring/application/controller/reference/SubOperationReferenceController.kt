package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.SubOperationService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.SubOperation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Controller
@RequestMapping("/references/subOperations")
class SubOperationReferenceController(private val subOperationService: SubOperationService) {

    @GetMapping
    fun getSubOperationsList(model: Model): String {
        model.addAttribute("subOperationList", subOperationService.all())
        return "/"
    }

    @GetMapping("/{:id}")
    fun getSubOperationById(model: Model, @PathVariable id: String): String {
        return "/"
    }

    @GetMapping("/new")
    fun getSubOperationForm(model: Model): String {
        var subOperation = SubOperation()
        model.addAttribute("subOperation", subOperation)
        return "/"
    }

    @PostMapping
    fun addSubOperation(@ModelAttribute subOperation: SubOperation): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        subOperation.timeDateModified = LocalDateTime.now().format(formatter)
        subOperation.userModified = auth.name
        subOperationService.add(subOperation)
        return "redirect:/"
    }

    @PutMapping("/{id}")
    fun editSubOperation(
        @PathVariable id: Long,
        model: Model
    ): String {
        var subOperation = subOperationService.get(id)
        model.addAttribute(subOperation)
        return "/"
    }

    @DeleteMapping("/{subOperationId}")
    fun deleteOperation(@PathVariable subOperationId: Long, model: Model): String {
        subOperationService.remove(subOperationId)
        return "redirect:/references/operations"
    }
}