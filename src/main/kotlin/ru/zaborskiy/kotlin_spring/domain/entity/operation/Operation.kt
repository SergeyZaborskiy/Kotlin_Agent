package ru.zaborskiy.kotlin_spring.domain.entity.operation

import ru.zaborskiy.kotlin_spring.domain.entity.Schedule
import javax.persistence.*

@Entity
@Table(name = "operations")
data class Operation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    var id: Long = 0L,

    @Column(name = "operation_name")
    var name: String = ""

) {

    @Column(name = "user_modified")
    var userModified: String = ""

    @Column(name = "time_date_modified")
    var timeDateModified: String = ""

    @OneToMany(
        mappedBy = "operation",
        cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST]
    )
    var listOfSubOperations: MutableList<SubOperation> = mutableListOf()

    @ManyToMany(cascade = [CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST])
    @JoinTable(
        name = "schedule_operation",
        joinColumns = [JoinColumn(name = "operation_id")],
        inverseJoinColumns = [JoinColumn(name = "schedule_id")]
    )
    var listOfSchedules: MutableList<Schedule> = mutableListOf()


    //Functions that add to lists

    fun addSubOperationToList(subOperation: SubOperation) {
        listOfSubOperations.add(subOperation)
        subOperation.operation = this
    }

    fun addScheduleToList(schedule: Schedule) {
        listOfSchedules.add(schedule)
    }

}