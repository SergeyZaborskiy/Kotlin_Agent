package ru.zaborskiy.kotlin_spring.domain.entity.operation

import javax.persistence.*

@Entity
@Table(name = "operations")
class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    var id: Long = 0L

    @Column(name = "operation_name")
    var name: String = ""

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @OneToMany(
        mappedBy = "operation",
        cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST]
    )
    var subOperationList: MutableList<SubOperation> = mutableListOf()


    //Function
    fun addSubOperationToOperation(subOperation: SubOperation) {
        subOperationList.add(subOperation)
        subOperation.operation = this
    }

}