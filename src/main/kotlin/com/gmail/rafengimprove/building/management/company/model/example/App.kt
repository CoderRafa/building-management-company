package com.gmail.rafengimprove.building.management.company.model.example

import com.gmail.rafengimprove.building.management.company.model.*
import com.gmail.rafengimprove.building.management.company.model.ParkingPlaceType.STREET
import com.gmail.rafengimprove.building.management.company.model.example.FilterType.*
import java.time.LocalDate
import java.util.*

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

data class RequiredParkingPlaceParameters(
    val length: Double = 0.0,
    val width: Double = 0.0,
    val type: ParkingPlaceType = STREET,
    val covered: Boolean = false,
    val security: Boolean = false,
    val condition: (
        Double, Double,
        Double, Double,
        ParkingPlaceType, ParkingPlaceType,
        Boolean, Boolean,
        Boolean, Boolean,
    ) -> Boolean = {
            parkingLength: Double, requiredLength: Double,
            parkingWidth: Double, requiredWidth: Double,
            parkingType: ParkingPlaceType, requiredParkingType: ParkingPlaceType,
            isCovered: Boolean, coverRequirement: Boolean,
            isSecure: Boolean, securityRequirement: Boolean,
        ->
        requiredLength <= parkingLength && parkingLength <= requiredLength + (requiredLength * 0.2) &&
                requiredWidth <= parkingWidth && parkingWidth <= requiredWidth + (requiredWidth * 0.2) &&
                parkingType == requiredParkingType && isCovered == coverRequirement &&
                isSecure == securityRequirement
    }
)

interface ParkingParametersComparator {
    fun compare(one: Any, two: Any): Boolean
}

class LengthParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Double <= two as Double && two <= one + (one * 0.2)
    }
}

class WidthParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Double <= two as Double && two <= one + (one * 0.2)
    }
}

class ParkingTypeParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as ParkingPlaceType == two as ParkingPlaceType
    }
}

class CoveredParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Boolean == two as Boolean
    }
}

class SecuredParkingParametersComparator : ParkingParametersComparator {
    override fun compare(one: Any, two: Any): Boolean {
        return one as Boolean == two as Boolean
    }
}

class ParkingPlaceFilter(
    val comparators: EnumMap<FilterType, ParkingParametersComparator>
) {
    fun compareLength(requiredLength: Double, length: Double): Boolean {
        return comparators[LENGTH]?.compare(requiredLength, length) ?: false
    }
    fun compareWidth(requiredWidth: Double, width: Double): Boolean {
        return comparators[WIDTH]?.compare(requiredWidth, width) ?: false
    }
    fun compareParkingType(requiredParkingType: Double, parkingType: Double): Boolean {
        return comparators[TYPE]?.compare(requiredParkingType, parkingType) ?: false
    }
    fun compareCovered(requiredCover: Boolean, cover: Boolean): Boolean {
        return comparators[COVERED]?.compare(requiredCover, cover) ?: false
    }
    fun compareSecured(requiredSecurity: Boolean, security: Boolean): Boolean {
        return comparators[SECURED]?.compare(requiredSecurity, security) ?: false
    }

}

enum class FilterType {
    LENGTH, WIDTH, TYPE, COVERED, SECURED
}


fun Apartment.requiredParkingPlace(requiredParkingPlaceParameters: RequiredParkingPlaceParameters) =
    with(requiredParkingPlaceParameters) {
        val parkingPlaceFilter = prepareParkingPlaceFilters()
            condition(
                length, parkingPlace.parkingPlaceLength,
                width, parkingPlace.parkingPlaceWidth,
                type, parkingPlace.parkingPlaceType,
                covered, parkingPlace.covered,
                security, parkingPlace.security
            )
    }

fun prepareParkingPlaceFilters() =
    ParkingPlaceFilter(EnumMap<FilterType, ParkingParametersComparator>(FilterType::class.java)).apply {
        this.comparators[LENGTH] = LengthParkingParametersComparator()
        this.comparators[WIDTH] = WidthParkingParametersComparator()
        this.comparators[TYPE] = ParkingTypeParkingParametersComparator()
        this.comparators[COVERED] = CoveredParkingParametersComparator()
        this.comparators[SECURED] = SecuredParkingParametersComparator()
    }

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
