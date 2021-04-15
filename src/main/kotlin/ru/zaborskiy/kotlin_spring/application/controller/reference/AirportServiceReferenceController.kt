package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.AirportServiceService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirportService
import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
@RequestMapping("/references/services")
class AirportServiceReferenceController(private val airportServiceService: AirportServiceService) {

    @GetMapping
    fun showServicesView(model: Model): String {
        model.addAttribute("airportServiceList", airportServiceService.all())
        return "/references/services/services_view"
    }

    @GetMapping("/{id}")
    fun showServiceForm(model: Model, @PathVariable id: String): String {
        return "/references/services/service_form"
    }

    @GetMapping("/new")
    fun getOperationForm(model: Model): String {
        var airportService = AirportService()
        model.addAttribute("airportService", airportService)
        return "/references/services/service_form"
    }

    @PostMapping
    fun addOperation(@ModelAttribute airportService: AirportService): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        airportService.timeDateModified = LocalDateTime.now().format(formatter)
        airportService.userModified = auth.name
        airportServiceService.add(airportService)
        return "redirect:/references/services"
    }

    @PutMapping("/{id}")
    fun editOperation(@PathVariable id: Long, model: Model): String {
        var airportService = airportServiceService.get(id)
        model.addAttribute(airportService)
        return "/references/services/service_form"
    }

    @DeleteMapping("/{id}")
    fun deleteOperation(@PathVariable id: Long): String {
        airportServiceService.remove(id)
        return "redirect:/references/services"
    }
}