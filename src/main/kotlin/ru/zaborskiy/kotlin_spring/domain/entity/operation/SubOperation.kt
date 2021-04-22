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

    @ManyToMany(cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "airportService_id")],
        inverseJoinColumns = [JoinColumn(name = "subOperation_id")]
    )
    var airportProductList: MutableList<AirportProduct> = mutableListOf()

    //Functions
    fun addSubOperationToService(airportProduct: AirportProduct) {
        airportProductList.add(airportProduct)
    }

}