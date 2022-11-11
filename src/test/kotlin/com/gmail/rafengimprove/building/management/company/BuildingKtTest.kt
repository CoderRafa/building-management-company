package com.gmail.rafengimprove.building.management.company

//class BuildingKtTest {
//
//    @Test
//    fun createNewBuildingTest() {
//        val building: Building = createNewBuilding()
//        assertAll(
//            { Assertions.assertThat(building.buildingMaterial).isInstanceOf(listOf(BRICK, CONCRETE)::class.java) },
//            { Assertions.assertThat(building.numberOfFloors).isNotNull() },
//            { Assertions.assertThat(building.numberOfFloors).isGreaterThan(0) },
//            { Assertions.assertThat(building.greenSpace).isEqualTo(200.0) },
//            { Assertions.assertThat(building.securityGuard).isEqualTo(false) },
//            { Assertions.assertThat(building.gym).isEqualTo(false) },
//            { Assertions.assertThat(building.distanceFromCityCenter).isEqualTo(10.0) },
//        )
//    }
//
//    private fun createNewBuilding(): Building {
//        return Building(
//            yearBuilt = LocalDate.parse("2018-12-31"),
//            buildingMaterial = listOf(BRICK, CONCRETE),
//            lastMajorRenovation = LocalDate.parse("2018-12-31"),
//            greenSpace = 200.0,
//            distanceFromCityCenter = 10.0,
//            neighbourhood = "Bronx",
//            numberOfFloors = 12,
//            totalNumberOfApartments = 42,
//            numberOfElevators = 2,
//            laundryRoom = true,
//            securityGuard = false,
//            concierge = false,
//            gym = false,
//            swimmingPool = true,
//
//        )
//    }
//
//}