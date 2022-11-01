package models

import java.time.LocalDate

data class Building(
    val yearBuilt: LocalDate,
    val buildingMaterial: List<BuildingMaterialType>,
    val lastMajorRenovation: LocalDate,
    val greenSpace: Double,
    val distanceFromCityCenter: Double,
    val neighbourhood: String,
    val numberOfFloors: Int,
    val numberOfApartmentsByType: List<Pair<ApartmentType, Int>>,
    val totalNumberOfApartments: Int,
    val numberOfElevators: Int,
    val laundryRoom: Boolean,
    val securityGuard: Boolean,
    val concierge: Boolean,
    val gym: Boolean,
    val swimmingPool: Boolean,
    val nearestSupermarket: Double,
    val nearestMall: Double,
    val nearestRestaurant: Double,
    val nearestCoffeeShop: Double,
    val nearestPub: Double,
    val nearestPublicTransport: Double,
    val nearestPark: Double,
    val nearestPlayground: Double,
    val nearestKindergarten: Double,
    val nearestSchool: Double,
) {

}

enum class ApartmentType {
    STUDIO,
    LOFT,
    PENTHOUSE,
    ONE_BEDROOM,
    TWO_BEDROOM
}

enum class BuildingMaterialType {
    BRICK,
    STONE,
    CONCRETE_BLOCKS,
    METAL_AND_GLASS,
    CONCRETE
}