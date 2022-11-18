package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.ApartmentType
import com.gmail.rafengimprove.building.management.company.model.ElectricalAppliances
import com.gmail.rafengimprove.building.management.company.model.FacingType
import com.gmail.rafengimprove.building.management.company.model.Furniture
import com.gmail.rafengimprove.building.management.company.model.ParkingPlace
import com.gmail.rafengimprove.building.management.company.model.RenovationType
import com.gmail.rafengimprove.building.management.company.model.UtilityBillType
import com.gmail.rafengimprove.building.management.company.model.ViewType
import java.time.LocalDate

data class Apartment(
    val entrance: String,
    val floor: Int,
    val apartmentNumber: Int,
    val apartmentType: ApartmentType,
    val numberOfRooms: Int,
    val areaInSquareMeters: Double,
    val rooms: List<Room>,
    val renovation: RenovationType,
    val heatInsulation: Boolean,
    val soundInsulation: Boolean,
    val heating: Boolean,
    val AC: Boolean,
    val smoking: Boolean,
    val petFriendly: Boolean,
    val wifi: Boolean,
    val parkingPlace: ParkingPlace,
    val includedUtilityBills: List<UtilityBillType>,
    val depositAmount: Double,
    val upfrontPayment: Double,
    val availability: Boolean,
    val availableFrom: LocalDate
)

fun Apartment.isRequiredApartmentType(requiredApartmentType: ApartmentType) = apartmentType == requiredApartmentType
fun Apartment.isRequiredArea(
    area: Double = 0.0,
    condition: (Double, Double) -> Boolean = { findArea: Double, appArea: Double -> findArea <= appArea && appArea <= findArea + (findArea * 0.2) }
) = condition(area, areaInSquareMeters)

fun Apartment.requiredRenovation(requiredRenovation: RenovationType) = renovation == requiredRenovation
fun Apartment.isHeatInsulated() = heatInsulation
fun Apartment.isSoundInsulated() = soundInsulation
fun Apartment.hasHeating() = heating
fun Apartment.hasAC() = AC
fun Apartment.isSmoking() = smoking
fun Apartment.isPetFriendly() = petFriendly
fun Apartment.hasWiFi() = wifi

fun Apartment.isAvailable() = availability
fun Apartment.hasBalcony() = rooms.any { it.hasBalcony() }
fun Apartment.hasSeeView() = lazy { rooms.any { it.hasView(ViewType.SEA_VIEW) } }.value
fun Apartment.hasView(view: ViewType) = rooms.any { it.hasView(view) }
fun Apartment.includesUtilityBills(includesUtilityBills: List<UtilityBillType>) =
    includesUtilityBills.all { includedUtilityBills.contains(it) }

data class Room(
    val windows: List<Window>,
    val squareMeters: Double,
    val roomType: RoomType,
    val balcony: Boolean,
    val ceilingHeight: Double,
    val views: List<ViewType>,
    val furniture: List<Furniture>,
    val electricalAppliances: List<ElectricalAppliances>,
    val facing: List<FacingType>,
)

fun Room.hasBalcony() = balcony
fun Room.hasView(view: ViewType): Boolean = views.any { it == view }
fun Room.hasFurniture(requiredFurniture: List<Furniture>) {
    requiredFurniture.all { furniture.contains(it) }
}

data class Window(
    val materialType: MaterialType,
    val glassesType: WindowGlassesType,
    val energyEfficient: Boolean,
    val width: Double,
    val height: Double
)


enum class RoomType {
    BEDROOM, BATHROOM, KITCHEN, HALL, LIVING_ROOM, STUDY, DINING_ROOM, TOILET
}

enum class MaterialType {
    WOOD, PLASTIC, ALUMINUM
}

enum class WindowGlassesType {
    DOUBLE_GLAZED,
    TRIPLE_GLAZED
}
