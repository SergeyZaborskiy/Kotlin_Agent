package ru.zaborskiy.kotlin_spring.configuration

import ru.zaborskiy.kotlin_spring.domain.entity.operation.Operation

class BestPracticeForDAO {

/*    //OneToMany
    var operations: List<Operation>

    //ManyToOne
    //need to change setter to this
    var operation = Operation()
        set(value) {
            if(sameAsCurrent(this.operation, value)) return
            this.operation = value
        }




    open fun setOwner(owner: SafePerson) {
        //prevent endless loop
        if (sameAsFormer(owner)) return
        //set new owner
        val oldOwner: SafePerson = owner
        owner = owner
        //remove from the old owner
        if (oldOwner != null) oldOwner.removeTwitterAccount(this)
        //set myself into new owner
        if (owner != null) owner.addTwitterAccount(this)
    }

    private fun sameAsCurrent(operation: Operation, newOperation: Operation): Boolean {
        return operation == null || newOperation == null || operation == newOperation
    }*/

}