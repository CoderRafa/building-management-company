package com.gmail.rafengimprove.building.management.company.model

data class ParkingPlace(
    val parkingPlaceLength: Double,
    val parkingPlaceWidth: Double,
    val parkingPlaceType: ParkingPlaceType,
    val covered: Boolean,
    val security: Boolean
){}

enum class ParkingPlaceType {
    STREET,
    PARKING_LOT,
    SINGLE_LEVEL_PARKING_GARAGE,
    MULTILEVEL_PARKING_GARAGE,
    UNDERGROUND_PARKING_GARAGE,
    AUTOMATED_PARKING_SYSTEM,
}
