package com.gmail.rafengimprove.building.management.company.model

data class ElectricalAppliances(
    val electricalApplianceType: ElectricalAppliancesType,
    val condition: ConditionType,
    val brand: BrandType
) {}

enum class BrandType {
    WHIRLPOOL,
    BOSCH,
    MIELE,
    SAMSUNG,
    INDESIT,
    LG,
    KITCHENAID,
    GE,
    ELECTROLUX,
    PANASONIC,
    HAIER,
    HITACHI,
    HOTPOINT,
    FRIGIDAIRE,
    MAYTAG,
    VIKING_RANGE,
    KENMORE,
    THERMADOR,
    FISHER_AND_PAYKEL,
    GAGGENAU,
    AMICA,
    BRAUN,
    CANDY,
    BEKO,
    DELONGHI,
    GORENJE,
    GRUNDIG,
    GREE_ELECTRIC,
    HISENSE,
    MITSUBISHI_ELECTRIC,
    MOULINEX,
    ROWENTA,
    PHILIPS,
    SHARP,
    TEFAL,
    LIEBHERR,
    AEG,
    NEO
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