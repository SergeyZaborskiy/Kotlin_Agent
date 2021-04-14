package ru.zaborskiy.kotlin_spring.domain.entity.operation

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="operations")
class Operation {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    var id: Long = 0L
    @Column(name="operation_name")
    var name:String? = null
    @Column(name="user_modified")
    var userModified:String? = null
    @Column(name="time_date_modified")
    var timeDateModified:Int? = null
}