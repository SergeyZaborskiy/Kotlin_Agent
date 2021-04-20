package ru.zaborskiy.kotlin_spring.domain.entity.operation

import javax.persistence.*

@Entity
@Table(name = "sub_operations")
data class SubOperation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subOperations_id")
    var id: Long = 0L,

    @Column(name = "subOperations_name")
    var name: String = "",

    @ManyToOne
    @JoinColumn(name = "operation_id")
    var operation: Operation = Operation(),

    ) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @ManyToMany
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "airportService_id")],
        inverseJoinColumns = [JoinColumn(name = "subOperation_id")]
    )
    var airportServiceList: MutableList<AirportService> = mutableListOf()

    //Functions
    fun addSubOperationToService(airportService: AirportService) {
        airportServiceList.add(airportService)
    }
}