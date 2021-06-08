package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.AircraftService
import ru.zaborskiy.kotlin_spring.application.service.AirportService
import ru.zaborskiy.kotlin_spring.application.service.ScheduleService
import ru.zaborskiy.kotlin_spring.domain.entity.ScheduleType
import ru.zaborskiy.kotlin_spring.domain.entity.airport.Airport
import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule


@Controller
@RequestMapping("/airports")
class AirportController(private val airportService: AirportService, private val scheduleService: ScheduleService, private val aircraftService: AircraftService) {

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
        model.addAttribute("airportId", airportId)
        return "/airports/airport_form"
    }

    @GetMapping("/{airportId}/schedules")
    fun getAirportSchedule(@PathVariable airportId: Long, model: Model): String {
        val returnedAirport = airportService.get(airportId)
        val returnedSchedules = returnedAirport.listOfAirportTechnologicalSchedules
        val planes = returnedSchedules.map { it.aircraft }.distinct()
        val typesOfSchedules = listOf<ScheduleType>(ScheduleType.Arrival, ScheduleType.Departure, ScheduleType.Revers)
        model.addAttribute("returnedSchedules", returnedSchedules)
        model.addAttribute("airportName", returnedAirport.name)
        model.addAttribute("airportId", returnedAirport.id)
        model.addAttribute("planes", planes)
        model.addAttribute("typesOfSchedules", typesOfSchedules)
        return "/airports/schedules_view"
    }

    @GetMapping("/{airportId}/schedules/new")
    fun getNewAirportScheduleForm(@PathVariable airportId: Long, model: Model): String {
        val returnedAirport = airportService.get(airportId)
        val newSchedule = AirportTechnologicalSchedule()
        model.addAttribute("airportId", airportId)
        model.addAttribute("returnedAirport", returnedAirport)
        model.addAttribute("newSchedule", newSchedule)
        model.addAttribute("typesOfSchedules", listOf<ScheduleType>(ScheduleType.Arrival, ScheduleType.Departure, ScheduleType.Revers))
        model.addAttribute("planes", aircraftService.all())
        return "/airports/schedule_new"
    }

    @PostMapping
    fun addAirport(@ModelAttribute airport:Airport ): String {
        airportService.add(airport)
        return "redirect:/airports"
    }

    @PostMapping("/schedules/new")
    fun addAirportSchedule(@ModelAttribute newTechnologicalSchedule: AirportTechnologicalSchedule): String {
        scheduleService.add(newTechnologicalSchedule)
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
