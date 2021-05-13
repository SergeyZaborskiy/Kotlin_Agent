package ru.zaborskiy.kotlin_spring.domain.entity

enum class ScheduleType(val type: String) {
    Arrival("Посадка"),
    Departure("Взлет"),
    Revers("Оборотный")
}