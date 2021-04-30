package ru.zaborskiy.kotlin_spring.domain.entity.operation

import ru.zaborskiy.kotlin_spring.domain.entity.airport.AirportItem
import javax.persistence.*

@Entity
@Table(name = "sub_operations")
data class AirlineSubOperation(
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
    var airlineOperation: AirlineOperation = AirlineOperation()
        set(value) {
            if (sameAsCurrent(field, value)) return
            else field = value
            airlineOperation.addSubOperation(this)
        }

    @ManyToMany
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "airportService_id")],
        inverseJoinColumns = [JoinColumn(name = "subOperation_id")]
    )
    var airportProducts: MutableList<AirportItem> = mutableListOf()

    //Functions for lists
    fun addAirportProduct(airportProduct: AirportItem) {
        if (airportProducts.contains(airportProduct)) return
        else {
            airportProducts.add(airportProduct)
        }
    }

    fun removeAirportProduct(airportProduct: AirportItem) {
        if (!airportProducts.contains(airportProduct)) return
        else {
            airportProducts.remove(airportProduct)
        }
    }
}

//Functions
private fun sameAsCurrent(airlineOperation: AirlineOperation, newAirlineOperation: AirlineOperation): Boolean {
    return airlineOperation == null || newAirlineOperation == null || airlineOperation == newAirlineOperation
}

