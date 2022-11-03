package com.gmail.rafengimprove.building.management.company.model

import java.time.LocalDate

data class Building(
    val yearBuilt: LocalDate,
    val buildingMaterial: List<BuildingMaterialType>,
    val lastMajorRenovation: LocalDate,
    val greenSpace: Double,
    val distanceFromCityCenter: Double,
    val neighbourhood: String,
    val numberOfFloors: Int,
    val numberOfApartmentsByType: List<Apartment>,
    val totalNumberOfApartments: Int,
    val numberOfElevators: Int,
    val laundryRoom: Boolean,
    val securityGuard: Boolean,
    val concierge: Boolean,
    val gym: Boolean,
    val swimmingPool: Boolean,
    val publicTransport: List<PublicTransport>,
    val placesOfInterest: List<PlacesOfInterest>
) {

}

enum class BuildingMaterialType {
    BRICK,
    STONE,
    CONCRETE_BLOCKS,
    METAL_AND_GLASS,
    CONCRETE
}