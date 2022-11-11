package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.FurnitureType
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ApartmentFilterTest {
    @Test
    fun `Happy pass - find an apartment with flatt screen`() {
        val apps = listOf<Apartment>()

        Assertions.assertThat(
            apps
                .filter { apartment ->
                    apartment
                        .rooms
                        .first { room -> room.roomType == RoomType.LIVING_ROOM }
                        .furniture.any { furniture -> furniture.furnitureType == FurnitureType.FLOOR_LAMP }
                }
        ).isNotEmpty
    }
}