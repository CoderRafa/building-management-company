package com.gmail.rafengimprove.building.managing.company

import models.ApartmentType
import models.ApartmentType.*
import models.Building
import models.BuildingMaterialType.BRICK
import models.BuildingMaterialType.CONCRETE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDate

class BuildingKtTest {

    @Test
    fun createNewBuildingTest() {
        val building: Building = createNewBuilding()
        assertAll(
            { Assertions.assertThat(building.buildingMaterial).isInstanceOf(listOf(BRICK, CONCRETE)::class.java) },
            { Assertions.assertThat(building.numberOfFloors).isNotNull() },
            { Assertions.assertThat(building.numberOfFloors).isGreaterThan(0) },
            {
                Assertions.assertThat(building.totalNumberOfApartments)
                    .isEqualTo(building.numberOfApartmentsByType.sumOf { it.second })
            },
            { Assertions.assertThat(building.greenSpace).isEqualTo(200.0) },
            { Assertions.assertThat(building.securityGuard).isEqualTo(false) },
            { Assertions.assertThat(building.gym).isEqualTo(false) },
            { Assertions.assertThat(building.distanceFromCityCenter).isEqualTo(10.0) },
        )
    }

    private fun createNewBuilding(): Building {
        return Building(
            yearBuilt = LocalDate.parse("2018-12-31"),
            buildingMaterial = listOf(BRICK, CONCRETE),
            lastMajorRenovation = LocalDate.parse("2018-12-31"),
            greenSpace = 200.0,
            distanceFromCityCenter = 10.0,
            neighbourhood = "Bronx",
            numberOfFloors = 12,
            numberOfApartmentsByType = listOf(
                Pair(STUDIO, 5),
                Pair(LOFT, 4),
                Pair(ONE_BEDROOM, 16),
                Pair(TWO_BEDROOM, 15),
                Pair(PENTHOUSE, 2)
            ),
            totalNumberOfApartments = 42,
            numberOfElevators = 2,
            laundryRoom = true,
            securityGuard = false,
            concierge = false,
            gym = false,
            swimmingPool = true,
            nearestSupermarket = 300.0,
            nearestMall = 500.0,
            nearestRestaurant = 100.0,
            nearestCoffeeShop = 50.0,
            nearestPub = 30.0,
            nearestPublicTransport = 50.0,
            nearestPark = 350.0,
            nearestPlayground = 10.0,
            nearestKindergarten = 450.0,
            nearestSchool = 600.0
        )
    }

}