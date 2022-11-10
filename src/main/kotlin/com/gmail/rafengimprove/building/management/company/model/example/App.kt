package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.ApartmentType
import com.gmail.rafengimprove.building.management.company.model.ElectricalAppliances
import com.gmail.rafengimprove.building.management.company.model.FacingType
import com.gmail.rafengimprove.building.management.company.model.Furniture
import com.gmail.rafengimprove.building.management.company.model.ParkingPlace
import com.gmail.rafengimprove.building.management.company.model.RenovationType
import com.gmail.rafengimprove.building.management.company.model.UtilityBillType
import com.gmail.rafengimprove.building.management.company.model.ViewType
import com.gmail.rafengimprove.building.management.company.model.WindowType
import java.time.LocalDate

data class Apartment(
    val number: Int,
    val entrance: String,
    val floor: Int,
    val apartmentNumber: Int,
    val apartmentType: ApartmentType,
    val areaInSquareMeters: Double,
    val rooms: List<Room>,
    val renovation: RenovationType,
    val heatInsulation: Boolean,
    val soundInsulation: Boolean,
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
)

fun Apartment.isAvailable() = availability
fun Apartment.isSmoking() = smoking
fun Apartment.isWiFi() = internet
fun Apartment.hasBalcony() = rooms.any { it.hasBalcony() }
fun Apartment.hasSeeView() = lazy { rooms.any { it.hasView(ViewType.SEA_VIEW) } }.value
fun Apartment.hasView(view: ViewType) = rooms.any { it.hasView(view) }

data class Room(
    val windows: List<Window>,
    val squareMeters: Double,
    val roomType: RoomType,
    val numberOfRooms: Int,
    val windowsType: List<WindowType>,
    val balcony: Boolean,
    val ceilingHeight: Double,
    val views: List<ViewType>,
    val furniture: List<Furniture>,
    val electricalAppliances: List<ElectricalAppliances>,
    val facing: List<FacingType>,
)

fun Room.hasBalcony() = balcony
fun Room.hasView(view: ViewType): Boolean = views.any { it == view }

data class Window(val materialType: MaterialType, val width: Double, val height: Double)


enum class RoomType {
    BEDROOM, BATHROOM, KITCHEN, HAL, LIVING_ROOM
}

enum class MaterialType {
    WOOD, PLASTIC
}
