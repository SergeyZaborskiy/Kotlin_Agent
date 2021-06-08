package ru.zaborskiy.kotlin_spring.domain.entity.flight

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule
import javax.persistence.*

@Entity
@Table(name = "aircrafts")
data class Aircraft(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraft_id")
    var id: Long = 0L,

    @Column(name = "aircraft_name")
    var name: String = "",

    @Column(name = "aircraft_fullName")
    var fullName: String = "",

    @Column(name = "aircraft_rechargeCycleCost")
    var rechargeCycleCost: Int = 0,

    @Column(name = "aircraft_rechargeMinuteCost")
    var rechargeMinuteCost: Int = 0
) {

    @OneToMany(
        mappedBy = "airport",
        cascade = [CascadeType.ALL]
    )
    var listOfAirportTechnologicalSchedule: MutableList<AirportTechnologicalSchedule> = mutableListOf()

    //Functions that add to lists

    fun addScheduleToList(airportTechnologicalSchedule: AirportTechnologicalSchedule) {
        listOfAirportTechnologicalSchedule.add(airportTechnologicalSchedule)
    }

}