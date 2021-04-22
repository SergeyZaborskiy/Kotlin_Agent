package ru.zaborskiy.kotlin_spring.application.controller.reference

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ru.zaborskiy.kotlin_spring.application.service.ScheduleService
import ru.zaborskiy.kotlin_spring.domain.entity.Aircraft
import ru.zaborskiy.kotlin_spring.domain.entity.Airport

@Controller
@RequestMapping("/references/schedules")
class ScheduleReferenceController(private val scheduleService: ScheduleService) {

    @GetMapping
    fun showOperationsView(model: Model): String {
        var schedules = scheduleService.all()
        var listOfAirports: List<Airport> = schedules.map { it.airport }
        var listOfAircraft: List<Aircraft> = schedules.map { it.aircraft }

        model.addAttribute("schedules", schedules)
        model.addAttribute("airports", listOfAirports)
        model.addAttribute("aircrafts", listOfAircraft)

        return "/references/schedules/schedules_view"
    }

    @GetMapping("/{:id}")
    fun showOperationForm(model: Model, @PathVariable id: String): String {
        return "/references/schedules/schedule_form"
    }
}