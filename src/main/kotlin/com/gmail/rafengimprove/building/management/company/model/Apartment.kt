package com.gmail.rafengimprove.building.management.company.model

import java.time.LocalDate

data class Apartment(
    val entrance: String,
    val floor: Int,
    val apartmentNumber: Int,
    val apartmentType: ApartmentType,
    val areaInSquareMeters: Double,
    val numberOfRooms: Int,
    val renovation: RenovationType,
    val ceilingHeight: Double,
    val windowsType: List<WindowType>,
    val balcony: Boolean,
    val furniture: List<Furniture>,
    val electricalAppliances: List<ElectricalAppliances>,
    val view: List<ViewType>,
    val heatInsulation: Boolean,
    val soundInsulation: Boolean,
    val facing: List<FacingType>,
    val heating: Boolean,
    val AC: Boolean,
    val smoking: Boolean,
    val petFriendly: Boolean,
    val internet: Boolean,
    val parkingPlace: ParkingPlace,
    val includedUtilityBills: List<UtilityBillType>,
    val depositAmount: Double,
    val upfrontPayment: Double,
    val availability: Boolean,
    val availableFrom: LocalDate
)  {
    private val primePrice: Double = 0.0
    private val margin: Double = 0.0
    private val expenses: Double = 0.0
    val rentAmount = primePrice + margin
    val profit = margin - expenses
}

enum class ApartmentType {
    STUDIO,
    LOFT,
    PENTHOUSE,
    ONE_BEDROOM,
    TWO_BEDROOM
}

enum class UtilityBillType {
    WATER,
    ELECTRICITY,
    GAS,
    INTERNET,
    AC,
    HEATING
}


enum class FacingType {
    EAST,
    WEST,
    SOUTH,
    NORTH
}

enum class ViewType {
    CITY_VIEW,
    SEA_VIEW,
    LAKE_VIEW,
    FOREST_VIEW,
    YARD_VIEW
}

enum class WindowType {
    WOODEN_WINDOWS,
    ALUMINIUM_WINDOWS,
    PVC_WINDOWS,
    DOUBLE_GLAZED,
    TRIPLE_GLAZED,
    ENERGY_EFFICIENT,
    FRENCH_WINDOWS,
    LARGE_WINDOWS
}

enum class RenovationType {
    FULLY_RENOVATED,
    PARTIALLY_RENOVATED,
    FRESHLY_PAINTED
}