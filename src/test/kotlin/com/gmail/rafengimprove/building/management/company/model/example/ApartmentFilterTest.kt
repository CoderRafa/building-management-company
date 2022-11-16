package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.FurnitureType
import com.gmail.rafengimprove.building.management.company.model.ParkingPlaceType.UNDERGROUND_PARKING_GARAGE
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

    @Test
    fun `Happy pass - find an apartment with required area`() {
        val apps = listOf<Apartment>()

        Assertions.assertThat(
            apps
                .filter { apartment ->
                    apartment.isRequiredArea(20.0)
                }
        ).isNotEmpty
    }

    @Test
    fun `Happy pass - find an apartment with required area and custom condition`() {
        val apps = listOf<Apartment>()

        Assertions.assertThat(
            apps
                .filter { apartment ->
                    apartment.isRequiredArea(20.0) { needArea, appArea -> needArea >= appArea }
                }
        ).isNotEmpty
    }

    @Test
    fun `Happy pass - find a parkingPlace with required condition`() {
        val apps = listOf<Apartment>()

        Assertions.assertThat(
            apps
                .filter { apartment ->
                    apartment.requiredParkingPlace(
                        3.0, 4.0,
                        UNDERGROUND_PARKING_GARAGE,
                        true, true
                    )
                }
        ).isNotEmpty
    }
}