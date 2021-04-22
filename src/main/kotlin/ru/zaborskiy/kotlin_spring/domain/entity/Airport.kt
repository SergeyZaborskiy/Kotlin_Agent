package ru.zaborskiy.kotlin_spring.domain.entity

import javax.persistence.*

@Entity
@Table(name = "airports")
data class Airport(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    var id: Long = 0L,

    @Column(name = "airport_name")
    var name: String = "",

    @Column(name = "airport_icao")
    var icao: String = "",

    @Column(name = "airport_iata")
    var iata: String = ""
) {

    @OneToMany(
        mappedBy = "airport",
        cascade = [CascadeType.ALL]
    )
    var listOfSchedules: MutableList<Schedule> = mutableListOf()

    //Functions that add to lists

    fun addScheduleToList(schedule: Schedule) {
        listOfSchedules.add(schedule)
    }

}