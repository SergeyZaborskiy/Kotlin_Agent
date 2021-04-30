package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.zaborskiy.kotlin_spring.application.service.AircraftService
import ru.zaborskiy.kotlin_spring.domain.entity.flight.Aircraft
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/flights")

class FlightController(private val aircraftService: AircraftService) {
    @GetMapping
    fun getFlightsList(model: Model): String {
        return "/flights/flight_view"
    }

    @GetMapping("/{:id}")
    fun getFlightForm(model: Model, @PathVariable id: String): String {
        return "/flights/flight_form"
    }

    @GetMapping("/aircrafts")
    fun getAircraftList(model: Model): String {
        val aircrafts = aircraftService.all()
        model.addAttribute("aircrafts", aircrafts)
        return "/flights/aircraft_view"
    }

    @GetMapping("/aircrafts/new")
    fun getNewAircraftForm(model: Model): String {
        val aircraft = Aircraft()
        model.addAttribute("newAircraft", aircraft)
        return "/flights/aircraft_new"
    }

    @GetMapping("/aircrafts/{aircraftId}")
    fun getAircraftForm(model: Model, @PathVariable aircraftId: Long): String {
        val aircraft = aircraftService.get(aircraftId)
        model.addAttribute("returnedAircraft", aircraft)
        return "/flights/aircraft_form"
    }

    @PostMapping("/aircrafts")
    fun addNewAircraft(@ModelAttribute newAircraft: Aircraft): String {
        aircraftService.add(newAircraft)
        return "redirect:/flights/aircrafts"
    }

    @PutMapping("/aircrafts")
    fun editAircraft(@ModelAttribute returnedAircraft: Aircraft): String {
        aircraftService.add(returnedAircraft)
        return "redirect:/flights/aircrafts"
    }

    @DeleteMapping("/aircrafts/{aircraftId}")
    fun deleteAircraft(@PathVariable aircraftId: Long, request: HttpServletRequest, model: Model): String {
        aircraftService.remove(aircraftId)
        val referer = request.getHeader("Referer")
        return "redirect:$referer"
    }
}