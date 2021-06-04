package ru.zaborskiy.kotlin_spring.domain.entity.flight

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportSchedule
import javax.persistence.*

@Entity
@Table(name = "aircrafts")
data class Aircraft(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraft_id")
    var id: Long = 0L,

    @Column(name = "aircraft1_name")
    var name: String = ""
) {

    @OneToMany(
        mappedBy = "airport",
        cascade = [CascadeType.ALL]
    )
    var listOfAirportSchedule: MutableList<AirportSchedule> = mutableListOf()

    //Functions that add to lists

    fun addScheduleToList(airportSchedule: AirportSchedule) {
        listOfAirportSchedule.add(airportSchedule)
    }

}