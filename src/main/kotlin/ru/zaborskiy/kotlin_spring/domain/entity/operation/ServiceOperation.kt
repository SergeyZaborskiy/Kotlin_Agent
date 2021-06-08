package ru.zaborskiy.kotlin_spring.domain.entity.operation

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportServiceForMaintenance
import javax.persistence.*

@Entity
@Table(name = "service_operation")
data class ServiceOperation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_operation_id")
    var id: Long = 0L,

    @Column(name = "service_operation_name")
    var name: String = ""

) {

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "service_operation_service_group",
        joinColumns = [JoinColumn(name = "service_operation_id")],
        inverseJoinColumns = [JoinColumn(name = "subOperations_id")]
    )
    var serviceGroups: MutableList<ServiceGroup> = mutableListOf()


    @ManyToOne
    @JoinColumn(name = "subOperations_id")
    var serviceGroup = ServiceGroup()

    //Functions for lists

    fun addServiceGroup(serviceGroup: ServiceGroup) {
        if (serviceGroups.contains(serviceGroup)) return
        else {
            serviceGroups.add(serviceGroup)
        }
    }
}