package ru.zaborskiy.kotlin_spring.domain.entity

import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation
import javax.persistence.*

@Entity
@Table(name = "schedules")
data class Schedule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    var id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "airport_id")
    var airport: Airport = Airport(),

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    var aircraft: Aircraft = Aircraft()
) {
    @ManyToMany(cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(
        name = "schedule_operation",
        joinColumns = [JoinColumn(name = "schedule_id")],
        inverseJoinColumns = [JoinColumn(name = "operation_id")]
    )
    var listOfOperation: MutableList<Operation> = mutableListOf()


    //Functions that add to lists
    fun addOperationToList(operation: Operation) {
        listOfOperation.add(operation)
    }

}