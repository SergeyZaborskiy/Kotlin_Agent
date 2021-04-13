package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/references/operations")
class OperationReferenceController {

    @GetMapping
    fun showOperationsView(model: Model): String {
        return "/references/operations/operations_view"
    }

    @GetMapping("/{:id}")
    fun showOperationForm(model: Model, @PathVariable id: String): String {
        return "/references/operations/operation_form"
    }
}