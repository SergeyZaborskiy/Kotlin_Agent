package ru.zaborskiy.kotlin_spring.domain.entity.operation

import javax.persistence.*

@Entity
@Table(name = "services")
class AirportService(
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

    @ManyToMany(cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(
        name = "subOperation_airportService",
        joinColumns = [JoinColumn(name = "subOperation_id")],
        inverseJoinColumns = [JoinColumn(name = "airportService_id")]
    )
    var subOperationList: MutableList<SubOperation> = mutableListOf()


    //Functions
    fun addSubOperationToService(subOperation: SubOperation) {
        subOperationList.add(subOperation)
    }

}