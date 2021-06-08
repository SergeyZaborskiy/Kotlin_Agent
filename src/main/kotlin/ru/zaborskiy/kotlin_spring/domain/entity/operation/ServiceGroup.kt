package ru.zaborskiy.kotlin_spring.domain.entity.operation

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportServiceForMaintenance
import javax.persistence.*

@Entity
@Table(name = "sub_operations")
data class ServiceGroup(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subOperations_id")
    var id: Long = 0L,

    @Column(name = "subOperations_name")
    var name: String = ""

) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @ManyToOne(cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinColumn(name = "operation_id")
    var technologicalOperation: TechnologicalOperation = TechnologicalOperation()
        set(value) {
            if (sameAsCurrent(field, value)) return
            else field = value
            technologicalOperation.addSubOperation(this)
        }

    @ManyToMany
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "airportService_id")],
        inverseJoinColumns = [JoinColumn(name = "subOperation_id")]
    )
    var airportProducts: MutableList<AirportServiceForMaintenance> = mutableListOf()

    @OneToMany(mappedBy = "serviceGroup", cascade = [CascadeType.ALL])
    var serviceOperations: MutableList<ServiceOperation> = mutableListOf()


    //Functions for lists
    fun addAirportProduct(airportProduct: AirportServiceForMaintenance) {
        if (airportProducts.contains(airportProduct)) return
        else {
            airportProducts.add(airportProduct)
        }
    }

    fun removeAirportProduct(airportProduct: AirportServiceForMaintenance) {
        if (!airportProducts.contains(airportProduct)) return
        else {
            airportProducts.remove(airportProduct)
        }
    }

    fun addServiceOperation(serviceOperation: ServiceOperation) {
        if (serviceOperations.contains(serviceOperation)) return
        else {
            serviceOperations.add(serviceOperation)
        }
    }

    fun deleteAllServiceOperations() {
        serviceOperations.clear()
    }
}

//Functions
private fun sameAsCurrent(technologicalOperation: TechnologicalOperation, newTechnologicalOperation: TechnologicalOperation): Boolean {
    return technologicalOperation == null || newTechnologicalOperation == null || technologicalOperation == newTechnologicalOperation
}

