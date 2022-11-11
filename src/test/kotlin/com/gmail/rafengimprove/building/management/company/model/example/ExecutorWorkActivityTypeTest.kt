package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.example.ExecutorWorkActivityType.WORK_ACTIVE
import com.gmail.rafengimprove.building.management.company.model.example.ExecutorWorkActivityType.WORK_COMPLETE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class ExecutorWorkActivityTypeTest {

    @Test
    fun `Happy pass - test function findCompletedStatuses by lists`() {
        val statuses = findCompletedStatuses(
            setOf(WORK_COMPLETE),
            listOf(WORK_ACTIVE)
        )
        assertAll(
            { Assertions.assertThat(statuses.size).isEqualTo(3) },
            { Assertions.assertThat(statuses).contains(WORK_ACTIVE) },
        )
    }

    @Test
    fun `Happy pass - test function findCompletedStatuses by function`() {
        val statuses = findCompletedStatuses { baseStatuses ->
            baseStatuses.filter { it != WORK_COMPLETE } + listOf(WORK_ACTIVE)
        }
        assertAll(
            { Assertions.assertThat(statuses.size).isEqualTo(3) },
            { Assertions.assertThat(statuses).contains(WORK_ACTIVE) },
        )
    }
}