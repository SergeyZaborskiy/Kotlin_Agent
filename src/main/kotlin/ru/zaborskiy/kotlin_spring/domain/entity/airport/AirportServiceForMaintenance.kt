package ru.zaborskiy.kotlin_spring.domain.entity.airport

import ru.zaborskiy.kotlin_spring.domain.entity.operation.ServiceGroup
import javax.persistence.*

@Entity
@Table(name = "services")
class AirportServiceForMaintenance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airportService_id")
    var id: Long = 0L,

    @Column(name = "airportService_name")
    var name: String = ""

) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "subOperation_id")],
        inverseJoinColumns = [JoinColumn(name = "airportService_id")]
    )
    var subOperations: MutableList<ServiceGroup> = mutableListOf()

    //Functions for lists
    fun addSubOperation(subOperation: ServiceGroup) {
        if (subOperations.contains(subOperation)) return
        else subOperations.add(subOperation)
    }

    fun removeSubOperation(subOperation: ServiceGroup) {
        if (!subOperations.contains(subOperation)) return
        else subOperations.remove(subOperation)
    }

}