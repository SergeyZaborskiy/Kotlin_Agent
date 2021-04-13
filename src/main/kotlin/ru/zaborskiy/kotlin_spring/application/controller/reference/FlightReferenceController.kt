package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/references/flights")

class FlightReferenceController {
    @GetMapping
    fun showFlightsView(model: Model): String {
        return "/references/flights/flight_view"
    }

    @GetMapping("/{:id}")
    fun showFlightForm(model: Model, @PathVariable id: String): String {
        return "/references/flights/flight_form"
    }
}