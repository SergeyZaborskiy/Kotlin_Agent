package ru.zaborskiy.kotlin_spring.domain.entity

import javax.persistence.*

@Entity
@Table(name = "aircrafts")
data class Aircraft(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraft_id")
    var id: Long = 0L,

    @Column(name = "aircraft_name")
    var name: String = ""
) {

    @OneToMany(
        mappedBy = "airport",
        cascade = [CascadeType.ALL]
    )
    var listOfSchedule: MutableList<Schedule> = mutableListOf()

    //Functions that add to lists

    fun addScheduleToList(schedule: Schedule) {
        listOfSchedule.add(schedule)
    }

}