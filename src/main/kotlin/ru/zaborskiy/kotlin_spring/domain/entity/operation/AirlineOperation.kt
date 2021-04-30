package ru.zaborskiy.kotlin_spring.domain.entity.operation

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportOperationSchedule
import javax.persistence.*

@Entity
@Table(name = "operations")
data class AirlineOperation(
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
        mappedBy = "airlineOperation",
        cascade = [CascadeType.ALL]
    )
    var airlineSubOperations: MutableList<AirlineSubOperation> = mutableListOf()

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "schedule_operation",
        joinColumns = [JoinColumn(name = "operation_id")],
        inverseJoinColumns = [JoinColumn(name = "schedule_id")]
    )
    var airportOperationSchedules: MutableList<AirportOperationSchedule> = mutableListOf()


    //Functions for lists
    fun addSubOperation(airlineSubOperation: AirlineSubOperation) {
        if (airlineSubOperations.contains(airlineSubOperation)) return
        else {
            airlineSubOperations.add(airlineSubOperation)
            airlineSubOperation.airlineOperation = this
        }
    }

    fun addSchedule(airportOperationSchedule: AirportOperationSchedule) {
        if (airportOperationSchedules.contains(airportOperationSchedule)) return
        else {
            airportOperationSchedules.add(airportOperationSchedule)
        }
    }

    fun removeSubOperation(airlineSubOperation: AirlineSubOperation) {
        if (!airlineSubOperations.contains(airlineSubOperation)) return
        else {
            airlineSubOperations.remove(airlineSubOperation)
        }

    }

    fun removeSchedule(airportOperationSchedule: AirportOperationSchedule) {
        if (!airportOperationSchedules.contains(airportOperationSchedule)) return
        else {
            airportOperationSchedules.remove(airportOperationSchedule)
        }
    }

}