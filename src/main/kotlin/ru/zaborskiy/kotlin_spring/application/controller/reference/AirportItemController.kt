package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.AirportProductService
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportServiceForMaintenance
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
@RequestMapping("/references/services")
class AirportItemController(private val airportProductService: AirportProductService) {

    @GetMapping
    fun showServicesView(model: Model): String {
        model.addAttribute("airportServiceList", airportProductService.all())
        return "/references/services/services_view"
    }

    @GetMapping("/{id}")
    fun showServiceForm(model: Model, @PathVariable id: String): String {
        return "/references/services/service_form"
    }

    @GetMapping("/new")
    fun getOperationForm(model: Model): String {
        var airportService = AirportServiceForMaintenance()
        model.addAttribute("airportService", airportService)
        return "/references/services/service_form"
    }

    @PostMapping
    fun addOperation(@ModelAttribute airportServiceForMaintenance: AirportServiceForMaintenance): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var auth = SecurityContextHolder.getContext().authentication
        airportServiceForMaintenance.timeDateModified = LocalDateTime.now().format(formatter)
        airportServiceForMaintenance.userModified = auth.name
        airportProductService.add(airportServiceForMaintenance)
        return "redirect:/references/services"
    }

    @PutMapping("/{id}")
    fun editOperation(@PathVariable id: Long, model: Model): String {
        var airportProduct = airportProductService.get(id)
        model.addAttribute("airportProduct", airportProduct)
        return "/references/services/service_form"
    }

    @DeleteMapping("/{id}")
    fun deleteOperation(@PathVariable id: Long): String {
        airportProductService.remove(id)
        return "redirect:/references/services"
    }
}