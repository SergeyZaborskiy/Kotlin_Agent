package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/references/services")
class ServiceReferenceController {

    @GetMapping
    fun showServicesView(model: Model): String {
        return "/references/services/services_view"
    }

    @GetMapping("/{:id}")
    fun showServiceForm(model: Model, @PathVariable id: String): String {
        return "/references/services/service_form"
    }
}