package models

data class Apartment(
    val apartmentType: ApartmentType,
    val areaInSquareMeters: Double,
    val numberOfRooms: Int,
    val renovation: RenovationType,
    val ceilingHeight: Double,
    val windowsType: List<WindowType>,
    val balcony: Boolean,
    val furnished: Boolean,
    val electricalAppliances: List<ElectricalAppliancesType>,
    val view: ViewType,
    val heatInsulation: Boolean,
    val soundInsulation: Boolean,
    val facing: List<FacingType>,
    val heating: Boolean,
    val AC: Boolean,
    val energyEfficient: Boolean,
    val smoking: Boolean,
    val petFriendly: Boolean,
    val internet: Boolean,
    val parkingPlace: Boolean,
    val primePrice: Double,
    val totalPrice: Double,
    val profit: Double,
    val includedUtilityBills: List<UtilityBillType>,
    val depositAmount: Double,
    val upfrontPayment: Double
) {

}

enum class UtilityBillType {
    WATER,
    ELECTRICITY,
    GAS,
    INTERNET,
    AC,
    HEATING
}

enum class ElectricalAppliancesType {
    WASHING_MACHINE,
    DISH_WASHER,
    FRIDGE,
    FREEZER,
    OVEN,
    STOVE,
    COOKER,
    DEEP_FRYER,
    ELECTRIC_KETTLE,
    KITCHEN_HOOD,
    DRYER,
    MICROWAVE,
    TOASTER,
    BLENDER,
    HAND_MIXER,
    STAND_MIXER,
    FOOD_PROCESSOR,
    COFFEE_MACHINE,
    BREAD_MACHINE,
    ELECTRIC_GRILL,
    MULTI_COOKER,
    HAIR_DRYER,
    IRON,
    WATER_HEATER,
    WATER_COOLER,
    STEAMER,
    VACUUM_CLEANER,
    TV,
    SMART_TV,
    SMART_HOME,
    AIR_PURIFIER,
    HUMIDIFIER,
    DEHUMIDIFIER
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