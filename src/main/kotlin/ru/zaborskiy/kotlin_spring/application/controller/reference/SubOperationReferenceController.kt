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
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping("/references/subOperations")
class SubOperationReferenceController(private val subOperationService: SubOperationService) {

    @GetMapping("/new")
    fun getSubOperationForm(model: Model): String {
        var subOperation = SubOperation()
        model.addAttribute("subOperation", subOperation)
        return "redirect:/references/operations"
    }

    @PostMapping("/new")
    fun addSubOperation(@ModelAttribute subOperation: SubOperation, request: HttpServletRequest): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        subOperation.timeDateModified = LocalDateTime.now().format(formatter)
        subOperation.userModified = auth.name
        subOperationService.add(subOperation)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }

    @DeleteMapping("/{subOperationId}")
    fun deleteOperation(@PathVariable subOperationId: Long, request: HttpServletRequest, model: Model): String {
        var temp = subOperationService.get(subOperationId)
        subOperationService.removeObj(temp)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }
}