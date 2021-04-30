package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.AirportService
import ru.zaborskiy.kotlin_spring.domain.entity.airport.Airport
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineOperation
import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineSubOperation
import java.time.format.DateTimeFormatter


@Controller
@RequestMapping("/airports")
class AirportController(private val airportService: AirportService) {

    @GetMapping
    fun getAirportsList(model: Model): String {
        val airports = airportService.all()
        val countries = airports.map { it.country }.distinct()
        val cities = airports.map { it.city }.distinct()
        model.addAttribute("airports", airports)
        model.addAttribute("countries", countries)
        model.addAttribute("cities", cities)
        return "/airports/airports_view"
    }

    @GetMapping("/new")
    fun getNewAirportForm(model: Model): String {
        var airport = Airport()
        model.addAttribute("newAirport", airport)
        return "/airports/airport_new"
    }

    @GetMapping("/{airportId}")
    fun getAirportForm(@PathVariable airportId: Long, model: Model): String {
        val returnedAirport = airportService.get(airportId)
        model.addAttribute("returnedAirport", returnedAirport)
        return "/airports/airport_form"
    }

    @GetMapping("/{airportId}/schedules")
    fun getAirportSchedule(@PathVariable airportId: Long, model: Model): String {
        val returnedAirport = airportService.get(airportId)
        model.addAttribute("returnedAirport", returnedAirport)
        return "/airports/airport_form"
    }

    @PostMapping
    fun addAirport(@ModelAttribute airport: Airport): String {
        airportService.add(airport)
        return "redirect:/airports"
    }

    @PutMapping("/{airportId}")
    fun updateAirport(@PathVariable airportId: Long, @ModelAttribute returnedAirport: Airport): String {
        airportService.save(returnedAirport)
        return "redirect:/airports"
    }

    @DeleteMapping("/{airportId}")
    fun deleteAirport(@PathVariable airportId: Long): String {
        airportService.remove(airportId)
        return "redirect:/airports"
    }

}
