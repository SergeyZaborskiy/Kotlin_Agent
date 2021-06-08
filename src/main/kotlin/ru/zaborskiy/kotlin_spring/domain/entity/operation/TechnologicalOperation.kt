package ru.zaborskiy.kotlin_spring.domain.entity.operation

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportTechnologicalSchedule
import javax.persistence.*

@Entity
@Table(name = "operations")
data class TechnologicalOperation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    var id: Long = 0L,

    @Column(name = "operation_name")
    var name: String = ""

) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @OneToMany(
        mappedBy = "technologicalOperation",
        cascade = [CascadeType.ALL]
    )
    var serviceGroups: MutableList<ServiceGroup> = mutableListOf()

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "schedule_operation",
        joinColumns = [JoinColumn(name = "operation_id")],
        inverseJoinColumns = [JoinColumn(name = "schedule_id")]
    )
    var airportTechnologicalSchedules: MutableList<AirportTechnologicalSchedule> = mutableListOf()


    //Functions for lists
    fun addSubOperation(serviceGroup: ServiceGroup) {
        if (serviceGroups.contains(serviceGroup)) return
        else {
            serviceGroups.add(serviceGroup)
            serviceGroup.technologicalOperation = this
        }
    }

    fun addSchedule(airportTechnologicalSchedule: AirportTechnologicalSchedule) {
        if (airportTechnologicalSchedules.contains(airportTechnologicalSchedule)) {
            return
        }
        else {
            airportTechnologicalSchedules.add(airportTechnologicalSchedule)
            /*airportSchedule.addAirlineOperation(this)*/
        }
    }

    fun removeSubOperation(serviceGroup: ServiceGroup) {
        if (!serviceGroups.contains(serviceGroup)) return
        else {
            serviceGroups.remove(serviceGroup)
        }

    }

    fun removeSchedule(airportTechnologicalSchedule: AirportTechnologicalSchedule) {
        if (!airportTechnologicalSchedules.contains(airportTechnologicalSchedule)) return
        else {
            airportTechnologicalSchedules.remove(airportTechnologicalSchedule)
        }
    }

}