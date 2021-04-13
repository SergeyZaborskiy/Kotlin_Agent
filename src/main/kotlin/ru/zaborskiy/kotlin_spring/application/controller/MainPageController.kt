package ru.zaborskiy.kotlin_spring.application.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/")
class MainPageController {

    fun showMainPage(model: Model): String {
        val title: String = "Main page"
        model.addAttribute(title)
        return "index";
    }
}