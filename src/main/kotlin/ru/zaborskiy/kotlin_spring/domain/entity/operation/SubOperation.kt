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
    var name: String = ""

) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @ManyToOne
    @JoinColumn(name = "operation_id")
    var operation: Operation = Operation()
        set(value) {
            if (sameAsCurrent(field, value)) return
            else field = value
        }

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "airportService_id")],
        inverseJoinColumns = [JoinColumn(name = "subOperation_id")]
    )
    var airportProducts: MutableList<AirportProduct> = mutableListOf()

    //Functions for lists
    fun addAirportProduct(airportProduct: AirportProduct) {
        if (airportProducts.contains(airportProduct)) return
        else {
            airportProducts.add(airportProduct)
        }
    }

    fun removeAirportProduct(airportProduct: AirportProduct) {
        if (!airportProducts.contains(airportProduct)) return
        else {
            airportProducts.remove(airportProduct)
        }
    }
}

//Functions
private fun sameAsCurrent(operation: Operation, newOperation: Operation): Boolean {
    return operation == null || newOperation == null || operation == newOperation
}

