package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.example.ExecutorWorkActivityType.CLIENT_ADJUSTED
import com.gmail.rafengimprove.building.management.company.model.example.ExecutorWorkActivityType.WORKER_DISPUTED
import com.gmail.rafengimprove.building.management.company.model.example.ExecutorWorkActivityType.WORK_COMPLETE

enum class ExecutorWorkActivityType(private val type: String) {
    /**
     * Initial state: executor accepted the request, but hasn't yet checked in on the shift
     */
    WORK_PENDING("WORK_PENDING"),

    /**
     * Executor started but hasn't yet finished the shift
     */
    WORK_ACTIVE("WORK_ACTIVE"),

    /**
     * Client canceled the request or the executor refused a previously accepted shift
     */
    WORK_CANCELED("WORK_CANCELED"),//after WORK_PENDING or WORK_ACTIVE

    /**
     * Executor has finished work shift
     */
    WORK_COMPLETE("WORK_COMPLETE"),//after WORK_ACTIVE

    /**
     * Money earned by the executor as part of this activity is available for payment, according to the rules for the availability of funds
     */
    FUNDS_AVAILABLE("FUNDS_AVAILABLE"),//funds available for withdrawal

    /**
     * Client confirmed to the executor less time worked than was recorded by the timer
     */
    CLIENT_ADJUSTED("CLIENT_ADJUSTED"),

    /**
     * Executor did not agree with the time confirmed by the client, the shift was transferred by the administrator of Go! for arbitration
     */
    WORKER_DISPUTED("WORKER_DISPUTED"),

    // New statuses

    /**
     * Time that the executor worked has been confirmed
     */
    TIME_APPROVED("TIME_APPROVED"),

    /**
     * Money earned by the executor as part of this activity was partially paid to the executor
     */
    WORKER_PAID_PARTIALLY("WORKER_PAID_PARTIALLY"),

    /**
     * Money earned by the executor as part of this activity was fully paid to the executor
     */
    WORKER_PAID_FULLY("WORKER_PAID_FULLY"),

    /**
     * Executor didn't go to work shift
     */
    WORKER_NO_SHOW("WORKER_NO_SHOW"),
    WORKER_PAID("WORKER_PAID"),
    REMOVED_FROM_ACTIVITY("REMOVED_FROM_ACTIVITY")
}


fun findCompletedStatuses(
    needToExtract: Set<ExecutorWorkActivityType>,
    needToAdd: List<ExecutorWorkActivityType>
): List<ExecutorWorkActivityType> =
    listOf(
        WORKER_DISPUTED, CLIENT_ADJUSTED,
        WORK_COMPLETE
    ) - needToExtract + needToAdd


fun findCompletedStatuses(
    supplier: (baseList: Set<ExecutorWorkActivityType>) -> List<ExecutorWorkActivityType>
) =
    supplier(
        setOf(WORKER_DISPUTED, CLIENT_ADJUSTED, WORK_COMPLETE)
    )