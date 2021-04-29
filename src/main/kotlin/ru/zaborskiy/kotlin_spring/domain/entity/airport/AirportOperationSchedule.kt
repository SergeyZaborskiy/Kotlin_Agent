package ru.zaborskiy.kotlin_spring.domain.entity.airport

import ru.zaborskiy.kotlin_spring.domain.entity.operation.AirlineOperation
import ru.zaborskiy.kotlin_spring.domain.entity.flight.Aircraft
import javax.persistence.*

@Entity
@Table(name = "schedules")
data class AirportOperationSchedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    var id: Long = 0L

) {

    @ManyToOne
    @JoinColumn(name = "airport_id")
    var airport: Airport = Airport()
        set(value) {
            if (sameAsCurrent(field, value)) return
            else field = value
        }

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    var aircraft: Aircraft = Aircraft()
        set(value) {
            if (sameAsCurrent(field, value)) return
            else field = value
        }

    @ManyToMany(cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(
        name = "schedule_operation",
        joinColumns = [JoinColumn(name = "schedule_id")],
        inverseJoinColumns = [JoinColumn(name = "operation_id")]
    )
    var listOfAirlineOperation: MutableList<AirlineOperation> = mutableListOf()


    //Functions that add to lists
    fun addOperationToList(airlineOperation: AirlineOperation) {
        listOfAirlineOperation.add(airlineOperation)
    }

    private fun sameAsCurrent(airport: Airport, newAirport: Airport): Boolean {
        return airport == null || newAirport == null || airport == newAirport
    }

    private fun sameAsCurrent(aircraft: Aircraft, newAircraft: Aircraft): Boolean {
        return aircraft == null || newAircraft == null || aircraft == newAircraft
    }

}

