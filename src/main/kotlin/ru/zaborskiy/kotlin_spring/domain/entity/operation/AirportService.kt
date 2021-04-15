package ru.zaborskiy.kotlin_spring.domain.entity.operation

import javax.persistence.*

@Entity
@Table(name = "services")
class AirportService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "service_id")
    var id: Long = 0L

    @Column(name = "service_name")
    var name: String = ""

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""
}