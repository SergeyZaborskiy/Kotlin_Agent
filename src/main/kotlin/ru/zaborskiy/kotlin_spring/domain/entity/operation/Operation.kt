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
        cascade = [CascadeType.ALL]
    )
    var subOperations: MutableList<SubOperation> = mutableListOf()

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "schedule_operation",
        joinColumns = [JoinColumn(name = "operation_id")],
        inverseJoinColumns = [JoinColumn(name = "schedule_id")]
    )
    var schedules: MutableList<Schedule> = mutableListOf()


    //Functions for lists
    fun addSubOperation(subOperation: SubOperation) {
        if (subOperations.contains(subOperation)) return
        else {
            subOperations.add(subOperation)
            subOperation.operation=this
        }
    }

    fun addSchedule(schedule: Schedule) {
        if (schedules.contains(schedule)) return
        else {
            schedules.add(schedule)
        }
    }

    fun removeSubOperation(subOperation: SubOperation) {
        if (!subOperations.contains(subOperation)) return
        else {
            subOperations.remove(subOperation)
        }

    }

    fun removeSchedule(schedule: Schedule) {
        if (!schedules.contains(schedule)) return
        else {
            schedules.remove(schedule)
        }
    }

}