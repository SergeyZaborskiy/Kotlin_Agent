package ru.zaborskiy.kotlin_spring.domain.entity.operation

import javax.persistence.*

@Entity
@Table(name = "sub_operations")
data class SubOperation(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sub_operations_id")
    var id: Long = 0L,

    @Column(name = "sub_operations_name")
    var name: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operation_id")
    var operation: Operation = Operation(),

    ) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""
}