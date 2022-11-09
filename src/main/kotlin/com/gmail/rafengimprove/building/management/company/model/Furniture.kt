package com.gmail.rafengimprove.building.management.company.model

data class Furniture(
    val furnitureType: FurnitureType,
    val amount: Int,
    val condition: ConditionType,
    val material: MaterialType
) {
}

enum class FurnitureType {
    SOFA,
    ARMCHAIR,
    RECLINER_ARMCHAIR,
    MEDIA_STAND,
    SIDE_TABLE,
    CARPET,
    BOOKSHELF,
    CHAIR,
    BAR_CHAIR,
    KITCHEN_TABLE,
    KITCHEN_CABINETS,
    CUPBOARD,
    DINING_TABLE,
    COFFEE_TABLE,
    FLOOR_LAMP,
    TABLE_LAMP,
    GRANDFATHER_CLOCK,
    WALL_CLOCK,
    MIRROR,
    PLANT,
    VASE,
    WARDROBE,
    WALK_IN_WARDROBE,
    DOUBLE_BED_KING_SIZE,
    DOUBLE_BED_QUEEN_SIZE,
    SINGLE_BED,
    NIGHT_STAND,
    DRESSER,
    BEDROOM_BENCH,
    DRESSING_TABLE,
    DESK
}

enum class MaterialType {
    WOOD,
    FABRIC,
    LEATHER,
    METAL,
    PLASTIC,
    MDF,
    GLASS,
    ACRYLIC,
}

enum class ConditionType {
    NEW,
    NEARLY_NEW,
    USED
}
